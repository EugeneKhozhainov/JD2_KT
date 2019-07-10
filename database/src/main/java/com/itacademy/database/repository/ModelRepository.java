package com.itacademy.database.repository;

import com.itacademy.database.entity.BrandCatalogEntity;
import com.itacademy.database.entity.ModelCatalogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends PagingAndSortingRepository<ModelCatalogEntity, Long> {

    @Query("select e from ModelCatalogEntity e")
    List<ModelCatalogEntity> getAll();


}
