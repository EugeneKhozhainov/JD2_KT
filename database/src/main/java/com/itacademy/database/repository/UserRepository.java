package com.itacademy.database.repository;

import com.itacademy.database.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository <UserEntity, Long> {

    UserEntity findByUsername(String username);

}
