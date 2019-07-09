package com.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

    @RequestMapping(value = "/admin_menu")
    public String adminMenu() {
        return "admin_menu";
    }

    @RequestMapping(value = "/user_menu")
    public String userMenu() {
        return "user_menu";
    }

}
