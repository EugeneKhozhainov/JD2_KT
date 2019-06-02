package com.itacademy.database.dao.util;

import lombok.Cleanup;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class SessionManager {

    public static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static Session getSession(){
        return factory.openSession();
    }
}
