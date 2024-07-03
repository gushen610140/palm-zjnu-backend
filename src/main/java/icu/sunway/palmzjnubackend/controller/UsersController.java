package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.User;
import icu.sunway.palmzjnubackend.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping(value = "api/user")
    public void addUser(@RequestBody User user) {
        usersService.addUser(user);
    }


}
