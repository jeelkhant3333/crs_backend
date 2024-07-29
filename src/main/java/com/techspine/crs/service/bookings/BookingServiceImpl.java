package com.techspine.crs.service.bookings;

import com.techspine.crs.entity.Booking;
import com.techspine.crs.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void createBookingRequest(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAllBookingsByUser(Integer userId) {
        return bookingRepository.findAllBookingsByUser(userId);
    }
}
