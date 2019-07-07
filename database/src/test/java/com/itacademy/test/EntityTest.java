package com.itacademy.test;

import com.itacademy.database.dao.CarDao;
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
}
