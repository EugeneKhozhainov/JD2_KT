package com.itacademy.database.dao;

import com.itacademy.database.entity.*;

public class CarDao {

    private static final CarDao INSTANCE = new CarDao();

    public CarEntity getDefaultCar() {
        return CarEntity.builder()
                .brand("BMW")
                .model("X5")
                .price(5555.0)
                .status(String.valueOf(CarStatus.DAMAGED))
                .build();

    }

    public static CarDao getInstance() {
        return INSTANCE;
    }
}
