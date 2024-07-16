package icu.sunway.palmzjnubackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import icu.sunway.palmzjnubackend.mapper.UserMapper;
import icu.sunway.palmzjnubackend.model.Result;
import icu.sunway.palmzjnubackend.model.Token;
import icu.sunway.palmzjnubackend.model.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.Random;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final JavaMailSender javaMailSender;
    private final RedisTemplate<String, String> redisTemplate;

    public UserService(UserMapper userMapper, JavaMailSender javaMailSender, RedisTemplate<String, String> redisTemplate) {
        this.userMapper = userMapper;
        this.javaMailSender = javaMailSender;
        this.redisTemplate = redisTemplate;
    }

    public Result<User> postUser(User user) {
        userMapper.insert(user);
        return new Result<>(200, "success", user);
    }

    public Result<String> postUserEmail(String email) {
        // 创建一个邮件消息
        MimeMessage message = javaMailSender.createMimeMessage();
        // 创建 MimeMessageHelper
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, false);
            // 发件人邮箱和名称
            helper.setFrom("56038009@qq.com", "one-point-access");
            // 收件人邮箱
            helper.setTo(email);
            // 邮件标题
            helper.setSubject("一点通邮箱验证码");
            // 生成验证码
            Random randomGenerator = new Random();
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                code.append(randomGenerator.nextInt(10));
            }
            redisTemplate.opsForValue().set("code_" + email, code.toString());
            redisTemplate.expire("code_" + email, Duration.ofMinutes(5));
            // 邮件正文，第二个参数表示是否是HTML正文
            helper.setText("您的验证码是 <strong>" + code + "</strong>", true);
            // 发送
            javaMailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return new Result<>(200, "success", email);
    }

    public Result<User> postUserLogin(Token token) {
        User user = userMapper.selectById(token.getOpenid());
        if (user == null) {
            User newUser = new User(
                    token.getOpenid(),
                    "默认昵称",
                    "",
                    "",
                    "未知",
                    "",
                    token.getSessionKey(),
                    ""
            );
            userMapper.insert(newUser);
            return new Result<>(201, "注册成功", newUser);
        }
        return new Result<>(200, "登录成功", user);
    }

    public Result<User> getUserInfo(String sessionKey, String openid) {
        User user = userMapper.selectById(openid);
        return new Result<>(200, "success", user);
    }

    public Result<User> putUser(User user) {
        userMapper.updateById(user);
        return new Result<>(200, "success", user);
    }

    public Result<Boolean> checkUser(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        User user = userMapper.selectOne(queryWrapper);
        return new Result<>(200, "success", user != null);
    }

    public Result<Boolean> checkUserEmail(String email, String code) {
        String correspondingCode = redisTemplate.opsForValue().get("code_" + email);
        if (correspondingCode == null) {
            return new Result<>(400, "code invalid", false);
        }
        if (!correspondingCode.equals(code)) {
            return new Result<>(400, "code mismatch", false);
        }
        return new Result<>(200, "success", true);
    }

    public Result<User> registerUser(String email) {
        User user = new User();
        user.setEmail(email);
        userMapper.insert(user);
        return new Result<>(200, "success", user);
    }

}
