package com.itacademy;

import com.itacademy.config.ServiceConfig;
import com.itacademy.database.repository.CarRepository;
import com.itacademy.service.service.CarService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServiceConfigTest {

    @Test
    public void test() {
        System.out.println("start ServiceConfigTest");
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        System.out.println("context="+context);
        CarRepository carRepository = context.getBean(CarRepository.class);
        System.out.println("carService="+carRepository.findAll());

        CarService carService = context.getBean(CarService.class);
        System.out.println("carService="+carService.toString());
    }


}
