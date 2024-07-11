package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.mapper.UserMapper;
import icu.sunway.palmzjnubackend.model.User;
import icu.sunway.palmzjnubackend.type.Result;
import icu.sunway.palmzjnubackend.type.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Value("${dev-server}")
    private String devServer;

    public Result<User> postUser(User user) {
        userMapper.insert(user);
        return new Result<>(200, "success", user);
    }

    public Result<User> postUserLogin(Token token) {
        User user = userMapper.selectById(token.getOpenid());
        if (user == null) {
            User newUser = new User(
                    token.getOpenid(),
                    "默认昵称",
                    devServer + "/api/image/avatars/default.png",
                    "",
                    "未知",
                    "",
                    token.getSessionKey()
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

}
