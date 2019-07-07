package com.itacademy.database.dao;

import com.itacademy.database.dao.util.SessionManager;
import com.itacademy.database.entity.*;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static com.itacademy.database.dao.util.SessionManager.getSession;

public class CarDao extends BaseDaoImpl<Long, CarEntity> {

    private static final CarDao INSTANCE = new CarDao();

    public static CarDao getInstance() {
        return INSTANCE;
    }

    public CarEntity getDefaultCar() {
        return CarEntity.builder()
                .brand("BMW")
                .model("X5")
                .price(5555.0)
                .status(String.valueOf(CarStatus.DAMAGED))
                .build();

    }
}
