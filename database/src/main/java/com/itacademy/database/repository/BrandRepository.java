package com.itacademy.database.repository;

import com.itacademy.database.entity.BrandCatalogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends PagingAndSortingRepository<BrandCatalogEntity, Long> {

    @Query("select e from BrandCatalogEntity e order by e.id")
    List<BrandCatalogEntity> getAll();

    void deleteById(Long id);

    BrandCatalogEntity getBrandCatalogEntityById(Long id);
}
