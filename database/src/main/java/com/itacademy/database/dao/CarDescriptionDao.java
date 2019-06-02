package com.itacademy.database.dao;

import com.itacademy.database.entity.BaseEntity;
import com.itacademy.database.entity.CarDescription;
import com.itacademy.database.entity.CarEntity;
import lombok.ToString;



public class CarDescriptionDao extends  BaseDaoImpl<Long, CarDescription> {

    private static final CarDescriptionDao INSTANCE = new CarDescriptionDao();

    public static CarDescriptionDao getInstance() {
        return INSTANCE;
    }

    public CarDescription getDefaultCarDescription() {
        return CarDescription.builder()
                .description("New car")
                .carEntity(CarDao.getInstance().getDefaultCar())
                .build();
    }
}
