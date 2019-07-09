package com.itacademy.database.repository;

import com.itacademy.database.entity.OrderEntity;
import com.itacademy.database.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository <UserEntity, Long> {

    UserEntity findByUsername(String username);

    @Query("select e from UserEntity e")
    List<UserEntity> getAll(Pageable pageable);

}
