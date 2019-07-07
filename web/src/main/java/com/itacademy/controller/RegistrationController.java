package com.itacademy.controller;

import com.itacademy.database.entity.UserEntity;
import com.itacademy.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private UserRepository userRepository;

    @GetMapping(value = "/registration")
    public String doGet(Model model) {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String doPost(Model model, @ModelAttribute("userForm") UserForm userForm) {
        model.addAttribute("userForm", userRepository.save(UserEntity.builder()
                .name(userForm.getName())
                .password(userForm.getPassword())
                .role(userForm.getRole())
                .username(userForm.getUsername())
                .list(null)
                .build()));
        return "registration";
    }

}
