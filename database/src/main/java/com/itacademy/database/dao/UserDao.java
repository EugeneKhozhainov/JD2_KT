package com.itacademy.database.dao;

import com.itacademy.database.entity.Role;
import com.itacademy.database.entity.UserEntity;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    public UserEntity getDefaultUser() {
        return UserEntity.builder()
                .name("Eugene")
                .username("Eugene")
                .password("password")
                .company(CompanyDao.getInstance().getDefaultCompany())
                .role(Role.ADMIN)
                .build();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
