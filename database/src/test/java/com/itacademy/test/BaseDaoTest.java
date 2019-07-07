package com.itacademy.test;

import com.itacademy.database.dao.UserDao;
import com.itacademy.database.dao.util.SessionManager;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.entity.OrderEntity;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BaseDaoTest {

    public static SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();
    public final UserDao userDao = UserDao.getInstance();

    @Test
    public void test() {

    }
}
