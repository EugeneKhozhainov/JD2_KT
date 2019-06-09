package com.itacademy.test;

import com.itacademy.database.config.DatabaseConfig;
import com.itacademy.database.repository.CarRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringServiceTest {

    @Test
    public void test() {
        System.out.println("start SpringServiceTest");
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        System.out.println("context="+context);
        CarRepository carRepository = context.getBean(CarRepository.class);
        System.out.println("carService="+carRepository.findAll());
    }

}
