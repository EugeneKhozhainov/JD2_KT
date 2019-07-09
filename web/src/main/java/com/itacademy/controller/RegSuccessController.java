package com.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegSuccessController {

    @GetMapping(value = "/regsuccess")
    public String getReview() {
        return "reg_success";
    }
}
