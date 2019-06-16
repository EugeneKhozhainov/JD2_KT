package com.itacademy.controller;

import com.itacademy.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String getReview(Model model) {
        model.addAttribute("carList", carService.getFiltered("BMW", "X6", 200.0, 1, 5));
        return "carList";
    }

    @PostMapping
    public String doPost(Model model, @ModelAttribute("carForm") CarForm carForm) {
        System.out.println("carForm="+carForm);
        model.addAttribute("carList", carService.getFiltered("BMW", "X6", 200.0, carForm.getPageNumber(), carForm.getPageCount()));
        return "carList";
    }
}
