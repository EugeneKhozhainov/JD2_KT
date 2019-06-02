package com.itacademy.test;

import com.itacademy.database.dao.CarDao;
import com.itacademy.database.dao.CarDescriptionDao;
import com.itacademy.database.dao.CompanyDao;
import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.*;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class EntityTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void SaveUserEntity() {
        @Cleanup Session session = FACTORY.openSession();
        UserEntity user = UserDao.getInstance().getDefaultUser();
        Serializable id = session.save(user);
        assertNotNull(id);
        System.out.println(user);
    }

    @Test
    public void SaveCarEntity() {
        @Cleanup Session session = FACTORY.openSession();
        CarEntity car = CarDao.getInstance().getDefaultCar();
        Serializable id = session.save(car);
        assertNotNull(id);
        System.out.println(car);
    }

    @Test
    public void SaveCarDescriptionEntity() {
        @Cleanup Session session = FACTORY.openSession();
        CarDescription carDescription = CarDescriptionDao.getInstance().getDefaultCarDescription();
        Serializable id = session.save(carDescription);
        assertNotNull(id);
        System.out.println(carDescription);
    }

    @Test
    public void SaveCompanyEntity() {
        @Cleanup Session session = FACTORY.openSession();
        Company company = CompanyDao.getInstance().getDefaultCompany();
        Serializable id = session.save(company);
        assertNotNull(id);
        System.out.println(company);
    }

    @Test
    public void GetEntity() {
        @Cleanup Session session = FACTORY.openSession();

        UserEntity user = UserDao.getInstance().getDefaultUser();
        CarEntity car = CarDao.getInstance().getDefaultCar();
        CarDescription carDescription = CarDescriptionDao.getInstance().getDefaultCarDescription();
        Company company = CompanyDao.getInstance().getDefaultCompany();

        assertNotNull(user);
        assertNotNull(car);
        assertNotNull(carDescription);
        assertNotNull(company);

        Serializable save = session.save(user);
        Serializable save2 = session.save(car);
        Serializable save3 = session.save(carDescription);
        Serializable save4 = session.save(company);

        assertNotNull(save);
        assertNotNull(save2);
        assertNotNull(save3);
        assertNotNull(save4);

        UserEntity userGet = session.get(UserEntity.class, save);
        CarEntity carGet = session.get(CarEntity.class, save);
        CarDescription carDescriptionGet = session.get(CarDescription.class, save);
        Company companyGet = session.get(Company.class, save);

        System.out.println(userGet);
        System.out.println(carGet);
        System.out.println(carDescriptionGet);
        System.out.println(companyGet);

        assertNotNull(userGet);
        assertNotNull(carGet);
        assertNotNull(carDescriptionGet);
        assertNotNull(companyGet);
    }
}
