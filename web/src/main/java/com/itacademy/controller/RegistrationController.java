package com.itacademy.controller;

import com.itacademy.controller.form.UserForm;
import com.itacademy.database.entity.UserEntity;
import com.itacademy.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/registration")
    public String doGet() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String doPost(@ModelAttribute("userForm") UserForm userForm) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(1L);
        userEntity.setUsername(userForm.getUsername());
        userEntity.setPassword(userForm.getPassword());
        userEntity.setName(userForm.getName());
        userEntity.setRole(userForm.getRole());

        userService.save(userEntity);

        return "reg_success";
    }

}
