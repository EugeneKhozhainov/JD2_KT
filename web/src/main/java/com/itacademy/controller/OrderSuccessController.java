package com.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderSuccessController {

    @GetMapping(value = "/ordersuccess")
    public String getReview() {
        return "order_success";
    }
}
