package com.itacademy.controller;

import com.itacademy.controller.form.CarForm;
import com.itacademy.service.service.OrderService;
import com.itacademy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderListController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders")
    public String doGet(Model model) {
        model.addAttribute("orderList", orderService.getAll(1, 5));
        return "orderList";
    }

    @PostMapping(value = "/orders")
    public String doPost(Model model, @ModelAttribute("orderForm") CarForm carForm) {
        model.addAttribute("orderList", orderService.getAll(carForm.getPageNumber(), carForm.getPageCount()));
        return "orderList";
    }
}
