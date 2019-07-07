package com.itacademy.test;

import com.itacademy.database.config.DatabaseConfig;
import com.itacademy.database.entity.*;
import com.itacademy.database.repository.CarRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class SpringServiceTest {

    @Test
    public void test() {
        System.out.println("start SpringServiceTest");
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        System.out.println("context="+context);
        CarRepository carRepository = context.getBean(CarRepository.class);
        System.out.println("carService="+carRepository.findAll());
    }

    @Test
    public void test2() {
        UserEntity user = UserEntity.builder()
                .role(Role.USER)
                .name("d")
                .password("ddd")
                .username("ddddd")
                .build();
        CarEntity car = CarEntity.builder()
                .model("X6")
                .brand("BMW")
                .price(500.0)
                .status(String.valueOf(CarStatus.WORKING))
                .build();
        OrderEntity order = OrderEntity.builder()
                .created(LocalDate.now())
                .dateFrom(LocalDate.now())
                .dateTo(LocalDate.of(2020, 06, 16))
                .user(user)
                .status(OrderStatus.PENDING)
                .car(car)
                .build();

        System.out.println(user);
        System.out.println(car);
        System.out.println(order);
    }

}
