package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.User;
import icu.sunway.palmzjnubackend.service.UserService;
import icu.sunway.palmzjnubackend.type.Result;
import icu.sunway.palmzjnubackend.type.Token;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/api/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping(value = "/api/user/login")
    public Result<User> login(@RequestBody Token token) {
        return userService.login(token);
    }

    @PostMapping(value = "/api/user/info")
    public Result<User> getUserInfo(@RequestBody Token token) {
        return userService.getUserInfo(token);
    }
}
