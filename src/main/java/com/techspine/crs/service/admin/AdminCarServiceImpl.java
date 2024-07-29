package com.techspine.crs.service.admin;

import com.techspine.crs.entity.Car;
import com.techspine.crs.repository.AdminCarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCarServiceImpl implements AdminCarService{
    @Autowired
    private final AdminCarRepository adminCarRepository;

    public AdminCarServiceImpl(AdminCarRepository adminCarRepository) {
        this.adminCarRepository = adminCarRepository;
    }

    @Override
    public String addCar(Car car) {
        adminCarRepository.save(car);
        return "Car Added Successfully...";
    }

    @Override
    public Optional<Car> findCarById(Integer carId) {
        return adminCarRepository.findById(carId);
    }

    @Override
    public List<Car> findAllCars() {
        return adminCarRepository.findAll();
    }

    @Override
    public List<Car> findAllCarsByUser(Integer userId){
        return adminCarRepository.findAllCarsByUser(userId);
    }

    @Override
    public void updateCarById(Integer carId, Car car) {
        Optional<Car> checkCar = adminCarRepository.findById(carId);
        if (checkCar.isPresent()) {
            Car updatedCar = checkCar.get();
            updatedCar.setBodyType(car.getBodyType());
            updatedCar.setColor(car.getColor());
            updatedCar.setCompany(car.getCompany());
            updatedCar.setDescription(car.getDescription());
            updatedCar.setFuelType(car.getFuelType());
            updatedCar.setBooked(car.isBooked());
            updatedCar.setMileage(car.getMileage());
            updatedCar.setModel(car.getModel());
            updatedCar.setName(car.getName());
            updatedCar.setPrice(car.getPrice());
            updatedCar.setTopSpeed(car.getTopSpeed());
            updatedCar.setTransmission(car.getTransmission());

            adminCarRepository.save(updatedCar);
        } else {
            throw new EntityNotFoundException("Car with ID " + carId + " not found");
        }
    }


    @Override
    public void deleteCarById(Integer carId) {
        adminCarRepository.deleteById(carId);
    }
}
