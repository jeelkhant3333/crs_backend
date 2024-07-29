package com.techspine.crs.controller.admin;

import com.techspine.crs.entity.Car;
import com.techspine.crs.entity.User;
import com.techspine.crs.enums.UserRole;
import com.techspine.crs.service.admin.AdminCarServiceImpl;
import com.techspine.crs.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminCarController {

    private final AdminCarServiceImpl adminCarService;
    private final UserServiceImpl userService;

    @Autowired
    public AdminCarController(AdminCarServiceImpl adminCarService, UserServiceImpl userService) {
        this.adminCarService = adminCarService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addCar(@RequestBody Car car, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        if (user.getRole() == UserRole.CUSTOMER) {
            throw new RuntimeException("This user has not access to add car.");
        } else {
            car.setUser(user);
            car.setBooked(false);
            return adminCarService.addCar(car);
        }
    }

    @GetMapping("/car/{carId}")
    public Optional<Car> findCarBtId(@PathVariable Integer carId) {
        return adminCarService.findCarById(carId);
    }

    @GetMapping("/car/all")
    public List<Car> findAllCars() {
        return adminCarService.findAllCars();
    }

    @GetMapping("/cars/{userId}")
    public List<Car> findAllCarsByUser(@PathVariable Integer userId) {
        return adminCarService.findAllCarsByUser(userId);
    }

    @PutMapping("/{carId}")
    public String updateUser(@PathVariable Integer carId, @RequestBody() Car reqCar) throws Exception {
        adminCarService.updateCarById(carId, reqCar);
        return "Car Updated Successfully...";
    }

    @DeleteMapping("/{carId}")
    public String deleteUserById(@PathVariable Integer carId){
        adminCarService.deleteCarById(carId);
        return "Car Deleted Successfully...";
    }
}
