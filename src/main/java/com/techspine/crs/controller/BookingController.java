package com.techspine.crs.controller;

import com.techspine.crs.entity.Booking;
import com.techspine.crs.entity.Car;
import com.techspine.crs.entity.User;
import com.techspine.crs.enums.Status;
import com.techspine.crs.request.BookingRequest;
import com.techspine.crs.service.admin.AdminCarServiceImpl;
import com.techspine.crs.service.bookings.BookingServiceImpl;
import com.techspine.crs.service.user.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingServiceImpl bookingService;
    private final AdminCarServiceImpl adminCarService;
    private final UserServiceImpl userService;

    public BookingController(BookingServiceImpl bookingService, AdminCarServiceImpl adminCarService, UserServiceImpl userService) {
        this.bookingService = bookingService;
        this.adminCarService = adminCarService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createBookingRequest(@RequestBody()BookingRequest bookingRequest,@RequestHeader("Authorization")String jwt) throws Exception {
        Booking booking = new Booking();
        Optional<Car> car = adminCarService.findCarById(bookingRequest.getCarId());
        User user = userService.findUserByJwt(jwt);
        car.ifPresent(booking::setCar);
        booking.setUser(user);
        booking.setBookedFrom(bookingRequest.getBookedFrom());
        booking.setBookedTo(bookingRequest.getBookedTo());
        booking.setPaymentDetails(bookingRequest.getPaymentDetails());
        booking.setStatus(Status.PENDING);
        booking.setBookingDateTime(LocalDateTime.now());

        bookingService.createBookingRequest(booking);
        return "Booking Request Sent Successfully... Wait For Approval.";
    }

    @GetMapping("/bookings")
    public List<Booking> findAllBookingsByUser(@RequestHeader("Authorization")String jwt) throws Exception {
       User user = userService.findUserByJwt(jwt);
        return bookingService.findAllBookingsByUser(user.getUserId());
    }
}
