package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.UsersDao;
import icu.sunway.palmzjnubackend.pojo.UsersPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersDao usersDao;

    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<UsersPojo> getAllUsers() {
        return usersDao.selectList(null);
    }
}
