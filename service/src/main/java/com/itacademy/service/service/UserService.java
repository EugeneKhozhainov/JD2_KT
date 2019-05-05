package com.itacademy.service.service;


import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.User;

public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final UserDao userDao = UserDao.getInstance();

    public User getDefaultUser() {
        return userDao.getDefaultUser();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
