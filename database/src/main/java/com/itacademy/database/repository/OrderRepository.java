package com.itacademy.database.repository;

import com.itacademy.database.entity.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long> {

    @Query("select e from OrderEntity e")
    List<OrderEntity> getAll(Pageable pageable);

    @Query("select e from OrderEntity e where e.user.id = :userId")
    List<OrderEntity> getUserList(@Param("pageable") Pageable pageable, @Param("userId") Long userId);

}
