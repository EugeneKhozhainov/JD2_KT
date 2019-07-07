package com.itacademy.controller;

import com.itacademy.database.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserForm {

    public String name;
    public String username;
    public String password;
    public Role role;
}
