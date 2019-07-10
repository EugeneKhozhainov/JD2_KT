package com.itacademy.service.service;

import com.itacademy.database.dao.CarDao;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private static final CarService INSTANCE = new CarService();
    private final CarDao userDao = CarDao.getInstance();

    public CarEntity getDefaultCar() {
        return userDao.getDefaultCar();
    }

    public static CarService getInstance() {
        return INSTANCE;
    }

    public List<CarEntity> getFiltered(String brand, String model, Double price, Integer pageNumber, Integer pageCount){
        Pageable pageRequest = PageRequest.of(pageNumber - 1, pageCount);
        List<CarEntity> filtered = carRepository.getFiltered(brand, model, price, pageRequest);
        return filtered;
    }

    public List<CarEntity> getAll(Integer pageNumber, Integer pageCount) {
        Pageable pageRequest = PageRequest.of(pageNumber - 1, pageCount);
        List<CarEntity> all = carRepository.getAll(pageRequest);
        return all;
    }

    public List<CarEntity> getFree() {
        return carRepository.getFree();
    }

}
