package com.itacademy.database;

import com.itacademy.database.dao.CarDao;
import com.itacademy.database.dao.CarDescriptionDao;
import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.CarDescription;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.entity.UserEntity;
import lombok.Cleanup;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class main {
    public static void main(String[] args) {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserEntity user = UserDao.getInstance().getDefaultUser();
        CarEntity car = CarDao.getInstance().getDefaultCar();
        CarDescription carDescription = CarDescriptionDao.getInstance().getDefaultCarDescription();

        session.save(user);
        session.save(car);
        session.save(carDescription);


        session.getTransaction().commit();

    }
}
