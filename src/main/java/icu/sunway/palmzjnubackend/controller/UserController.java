package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.model.Result;
import icu.sunway.palmzjnubackend.model.User;
import icu.sunway.palmzjnubackend.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @GetMapping(value = "/api/user/login")
    public Result<User> login(String email, String password) {
        return userService.login(email, password);
    }

    @GetMapping(value = "/api/user/info")
    public Result<User> getUserInfo(String sessionKey, String openid) {
        return userService.getUserInfo(sessionKey, openid);
    }

    @PutMapping(value = "/api/user")
    public Result<User> putUser(@RequestBody User user) {
        return userService.putUser(user);
    }

    @GetMapping(value = "/api/user/email")
    public Result<String> postUserEmail(String email) {
        return userService.postUserEmail(email);
    }

    @GetMapping(value = "/api/user/check")
    public Result<Boolean> checkUser(String email) {
        return userService.checkUser(email);
    }

    @GetMapping(value = "/api/check/email")
    public Result<Boolean> checkUserEmail(String email, String code) {
        return userService.checkUserEmail(email, code);
    }

    @GetMapping(value = "/api/user/register")
    public Result<User> registerUser(String email) {
        return userService.registerUser(email);
    }

}
