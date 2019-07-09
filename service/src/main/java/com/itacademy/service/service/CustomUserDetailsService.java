package com.itacademy.service.service;

import com.itacademy.database.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        } else {
            User.UserBuilder builder = User.withUsername(username);
            builder.password(userEntity.getPassword());
            builder.authorities(userEntity.getRole().toString());
            UserDetails userDetails = builder.build();
            return userDetails;
        }
    }
}
