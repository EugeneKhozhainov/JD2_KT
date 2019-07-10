package com.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderSuccessController {

    @GetMapping(value = "/ordersuccess")
    public String orderSuccess() {
        return "order_success";
    }

    @GetMapping(value = "/deliverysuccess")
    public String deliverySuccess() {
        return "delivery_success";
    }

}
