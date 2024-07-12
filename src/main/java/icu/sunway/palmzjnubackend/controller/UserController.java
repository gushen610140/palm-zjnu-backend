package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.model.Result;
import icu.sunway.palmzjnubackend.model.Token;
import icu.sunway.palmzjnubackend.model.User;
import icu.sunway.palmzjnubackend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/api/user")
    public Result<User> postUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    @PostMapping(value = "/api/user/login")
    public Result<User> postUserLogin(@RequestBody Token token) {
        return userService.postUserLogin(token);
    }

    @GetMapping(value = "/api/user/info")
    public Result<User> getUserInfo(String sessionKey, String openid) {
        return userService.getUserInfo(sessionKey, openid);
    }

    @PutMapping(value = "/api/user")
    public Result<User> putUser(@RequestBody User user) {
        return userService.putUser(user);
    }

}
