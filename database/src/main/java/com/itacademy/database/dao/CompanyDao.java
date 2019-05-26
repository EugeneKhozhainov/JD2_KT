package com.itacademy.database.dao;

import com.itacademy.database.entity.Company;
import com.itacademy.database.entity.UserEntity;

public class CompanyDao {
    private static final CompanyDao INSTANCE = new CompanyDao();

    public Company getDefaultCompany() {
        return Company.builder()
                .name("Ez rent")
                .build();
    }

    public static CompanyDao getInstance() {
        return INSTANCE;
    }
}
