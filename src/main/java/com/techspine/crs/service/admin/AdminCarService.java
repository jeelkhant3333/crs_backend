package com.techspine.crs.service.admin;

import com.techspine.crs.entity.Car;
import com.techspine.crs.entity.User;

import java.util.List;
import java.util.Optional;

public interface AdminCarService {

    String addCar(Car car);
    Optional<Car> findCarById(Integer carId);
    List<Car> findAllCars();
    List<Car> findAllCarsByUser(Integer userId);
    void updateCarById(Integer carId, Car car);
    void deleteCarById(Integer carId);
}
