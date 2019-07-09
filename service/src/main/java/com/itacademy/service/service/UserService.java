package com.itacademy.service.service;

import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.OrderEntity;
import com.itacademy.database.entity.UserEntity;
import com.itacademy.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final UserDao userDao = UserDao.getInstance();

    public UserEntity getDefaultUser() {
        return userDao.getDefaultUser();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity userEntity) {
        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            throw new RuntimeException(String.format("User with username %s already exist", userEntity.getUsername()));
        }

        if (StringUtils.isEmpty(userEntity.getPassword())) {
            throw new RuntimeException(String.format("Password cannot be null"));
        }

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword().trim()));
        userRepository.save(userEntity);
        return userEntity;
    }

    public List<UserEntity> getAll(Integer pageNumber, Integer pageCount) {
        Pageable pageRequest = PageRequest.of(pageNumber - 1, pageCount);
        List<UserEntity> all = userRepository.getAll(pageRequest);
        return all;
    }

}
