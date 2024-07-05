package icu.sunway.palmzjnubackend.service;

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
                    null,
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
}
