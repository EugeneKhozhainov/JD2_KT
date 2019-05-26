package com.itacademy.service.service;

import com.itacademy.database.dao.CarDao;
import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.entity.UserEntity;

public class CarService {

    private static final CarService INSTANCE = new CarService();
    private final CarDao userDao = CarDao.getInstance();

    public CarEntity getDefaultCar() {
        return userDao.getDefaultCar();
    }

    public static CarService getInstance() {
        return INSTANCE;
    }
}
