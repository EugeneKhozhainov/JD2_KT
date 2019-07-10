package com.itacademy.database.repository;

import com.itacademy.database.entity.CarEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends PagingAndSortingRepository<CarEntity, Long> {

    @Query("select e from CarEntity e where e.brand = :brand and e.model = :model and e.price > :price order by e.price")
    List<CarEntity> getFiltered(@Param("brand") String brand, @Param("model") String model, @Param("price") Double price, Pageable pageable);

    @Query("select e from CarEntity e")
    List<CarEntity> getAll(Pageable pageable);

    CarEntity findByBrand(String brand);

    @Query("select e from CarEntity e where e.id not in (select o.car.id from OrderEntity o where o.car.id = e.id and o.status in ('BOOKED', 'DELIVERED'))")
    List<CarEntity> getFree();

}
