package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.UsersDao;
import icu.sunway.palmzjnubackend.pojo.UsersPojo;
import icu.sunway.palmzjnubackend.type.Status;
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

    public Status addUser(String username, String password, String phone, String email) {
        UsersPojo usersPojo = new UsersPojo(null, username, password, phone, email);
        if (usersDao.insert(usersPojo) > 0) {
            return Status.SUCCESS;
        } else {
            return Status.ERROR;
        }
    }
}
