package com.itacademy.database.dao;

import com.itacademy.database.entity.OrderEntity;

public class OrderDao extends BaseDaoImpl<Long, OrderEntity> {

    private static final OrderDao INSTANCE = new OrderDao();

    public static OrderDao getInstance() {
        return INSTANCE;
    }

}
