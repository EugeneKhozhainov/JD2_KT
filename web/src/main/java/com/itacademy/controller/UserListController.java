package com.itacademy.controller;

import com.itacademy.controller.form.CarForm;
import com.itacademy.controller.form.UserForm;
import com.itacademy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserListController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String doGet(Model model) {
        model.addAttribute("userList", userService.getAll(1, 5));
        return "userList";
    }

    @PostMapping(value = "/users")
    public String doPost(Model model, @ModelAttribute("carForm") CarForm carForm) {
        model.addAttribute("userList", userService.getAll(carForm.getPageNumber(), carForm.getPageCount()));
        return "userList";
    }
}
