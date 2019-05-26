package com.itacademy.service.service;

import com.itacademy.database.dao.CompanyDao;
import com.itacademy.database.entity.Company;

public class CompanyService {

    private static final CompanyService INSTANCE = new CompanyService();
    private final CompanyDao userDao = CompanyDao.getInstance();

    public Company getDefaultCompany() {
        return userDao.getDefaultCompany();
    }

    public static CompanyService getInstance() {
        return INSTANCE;
    }
}
