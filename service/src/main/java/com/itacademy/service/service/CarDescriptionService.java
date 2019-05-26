package com.itacademy.service.service;

import com.itacademy.database.dao.CarDao;
import com.itacademy.database.dao.CarDescriptionDao;
import com.itacademy.database.entity.CarDescription;
import com.itacademy.database.entity.CarEntity;

public class CarDescriptionService {

    private static final CarDescriptionService INSTANCE = new CarDescriptionService();
    private final CarDescriptionDao userDao = CarDescriptionDao.getInstance();

    public CarDescription getDefaultCarDescription() {
        return userDao.getDefaultCarDescription();
    }

    public static CarDescriptionService getInstance() {
        return INSTANCE;
    }
}
