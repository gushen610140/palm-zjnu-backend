package icu.sunway.palmzjnubackend.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import icu.sunway.palmzjnubackend.dao.UserMapper;
import icu.sunway.palmzjnubackend.pojo.User;
import icu.sunway.palmzjnubackend.type.Result;
import icu.sunway.palmzjnubackend.type.Token;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    public void addUser(User user) {
        userMapper.insert(user);
    }

    public Result<User> login(Token token) {
        User user = userMapper.selectById(token.getOpenid());
        if (user == null) {
            User newUser = new User(
                    token.getOpenid(),
                    "默认昵称",
                    "http://127.0.0.1:8080/api/images/avatars/default.png",
                    "",
                    "未知",
                    "",
                    token.getSessionKey()
            );
            userMapper.insert(newUser);
            return new Result<>(201, "user register", newUser);
        }
        return new Result<>(200, "user login", user);
    }

    public Result<User> getUserInfo(Token token) {
        User user = userMapper.selectById(token.getOpenid());
        return new Result<>(200, "success", user);
    }

    public Result<String> updateUserAvatarInfo(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", user.getUserId()).set("user_avatar", user.getUserAvatar());
        userMapper.update(null, updateWrapper);
        return new Result<>(200, "success", "update avatar successfully");
    }

    public Result<String> updateUserNameInfo(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", user.getUserId()).set("user_name", user.getUserName());
        userMapper.update(null, updateWrapper);
        return new Result<>(200, "success", "update name successfully");
    }

    public Result<String> updateUserGenderInfo(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", user.getUserId()).set("gender", user.getGender());
        userMapper.update(null, updateWrapper);
        return new Result<>(200, "success", "update gender successfully");
    }

    public Result<String> updateUserStudentNumberInfo(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", user.getUserId()).set("user_student_number", user.getUserStudentNumber());
        userMapper.update(null, updateWrapper);
        return new Result<>(200, "success", "update student number successfully");
    }

    public Result<String> updateWechatNumberInfo(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", user.getUserId()).set("wechat_number", user.getWechatNumber());
        userMapper.update(null, updateWrapper);
        return new Result<>(200, "success", "update wechat number successfully");
    }
}
