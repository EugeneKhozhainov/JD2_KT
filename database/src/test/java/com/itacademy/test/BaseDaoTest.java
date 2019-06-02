package com.itacademy.test;

import com.itacademy.database.dao.CompanyDao;
import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.Role;
import com.itacademy.database.entity.UserEntity;
import lombok.Cleanup;
import lombok.ToString;
import org.h2.engine.User;
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

    public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public final UserDao userDao = UserDao.getInstance();
    public final UserEntity testUser = UserEntity.builder()
            .name("Admin")
            .username("superadmin1337")
            .password("31313131")
            .role(Role.ADMIN)
            .company(CompanyDao.getInstance().getDefaultCompany())
            .build();



    @AfterClass
    public static void clear(){
        factory.close();
    }

    @Test
    public void checkSave(){
        @Cleanup Session session = factory.openSession();
        userDao.save(testUser);
        assertNotNull(session.get(UserEntity.class, 1L));
        session.close();
    }

    @Test
    public void checkDelete(){
        @Cleanup Session session = factory.openSession();
        userDao.save(testUser);
        userDao.delete(testUser);
        Assert.assertEquals(session.get(UserEntity.class, 1L), null);
        session.close();
    }

   /* @Test
    public void checkUpdate(){
        @Cleanup Session session = factory.openSession();
        userDao.save(testUser);
        UserEntity updateUser =  UserEntity.builder()
                .name("notsuperadmin")
                .username("notsuperadmin1337")
                .password("13131313")
                .role(Role.USER)
                .company(CompanyDao.getInstance().getDefaultCompany())
                .build();

        userDao.update(updateUser);
        System.out.println(session.get((UserEntity.class), 1L));
    }*/

   @Test
    public void checkGetId(){
       @Cleanup Session session = factory.openSession();
       userDao.save(testUser);
       assertNotNull(userDao.getId(1L));
       session.close();
   }

   @Test
   public void checkGetAll(){
       @Cleanup Session session = factory.openSession();
       final UserEntity testUser = UserEntity.builder()
               .name("Admin")
               .username("superadmin1337")
               .password("31313131")
               .role(Role.ADMIN)
               .company(CompanyDao.getInstance().getDefaultCompany())
               .build();

       final UserEntity testUser2 = UserEntity.builder()
               .name("Admin")
               .username("superadmin1337")
               .password("31313131")
               .role(Role.ADMIN)
               .company(CompanyDao.getInstance().getDefaultCompany())
               .build();

       final UserEntity testUser3 = UserEntity.builder()
               .name("Admin")
               .username("superadmin1337")
               .password("31313131")
               .role(Role.ADMIN)
               .company(CompanyDao.getInstance().getDefaultCompany())
               .build();

       userDao.save(testUser);
       userDao.save(testUser2);
       userDao.save(testUser3);

       List<UserEntity> all = userDao.getAll();
       assertNotNull(all);
       assertEquals(all.size(), 3);
       session.close();
   }
}
