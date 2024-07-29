package com.techspine.crs.service.bookings;

import com.techspine.crs.entity.Booking;

import java.util.List;

public interface BookingService {

    void createBookingRequest(Booking booking);
    List<Booking> findAllBookingsByUser(Integer userId);
}
