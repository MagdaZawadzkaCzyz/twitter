package com.sda.twitter.service;

import com.sda.twitter.exception.ImproperLoginCredentials;
import com.sda.twitter.persistance.dao.UserDao;
import com.sda.twitter.persistance.entities.TbUser;

public class UserService {
    private UserDao userDao = new UserDao();

    public TbUser getUserByUserName(String userName, String password) throws ImproperLoginCredentials {
        TbUser userByLogin = userDao.getUserByLogin(userName);
        if (userByLogin == null || !userByLogin.getPassword().equals(password)) {
            throw new ImproperLoginCredentials("password or username does not match");
        }
        return userByLogin;
    }
}
