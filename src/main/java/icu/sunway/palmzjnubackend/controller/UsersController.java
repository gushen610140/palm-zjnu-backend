package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.UsersPojo;
import icu.sunway.palmzjnubackend.service.UsersService;
import icu.sunway.palmzjnubackend.type.PostedUser;
import icu.sunway.palmzjnubackend.type.Status;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<UsersPojo> getAllUsers() {
        return usersService.getAllUsers();
    }

    @RequestMapping(value = "api/user", method = RequestMethod.POST)
    public Status addUser(@RequestBody PostedUser user) {
        return usersService.addUser(user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail());
    }


}
