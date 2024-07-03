package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.UserMapper;
import icu.sunway.palmzjnubackend.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UserMapper userMapper;

    public UsersService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    public void addUser(User user) {
        userMapper.insert(user);
    }
}
