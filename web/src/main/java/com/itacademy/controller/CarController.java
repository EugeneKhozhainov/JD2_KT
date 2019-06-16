package com.itacademy.controller;

import com.itacademy.config.WebConfig;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.service.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    @GetMapping
    public String doGet(Model model) {
        return "car";
    }

    @PostMapping
    public String doPost(Model model) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        CarService carService = context.getBean(CarService.class);
        List<CarEntity> list = carService.getFiltered("BMW", "X6", 200.0, 1, 10);
        model.addAttribute("carList", list);
        return "car";
    }

}
