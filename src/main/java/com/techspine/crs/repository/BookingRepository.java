package com.techspine.crs.repository;

import com.techspine.crs.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId")
    List<Booking> findAllBookingsByUser(@Param("userId") Integer userId);
}
