package com.techspine.crs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techspine.crs.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private int bookingId;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
    private String bookedFrom;
    private String bookedTo;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    @CollectionTable(name = "payment_details", joinColumns = @JoinColumn(name = "booking_id"))
    private PaymentDetails paymentDetails;
    private LocalDateTime bookingDateTime;


    public Booking() {
    }

    public Booking(int bookingId, Car car, User user, String bookedFrom, String bookedTo, Status status, PaymentDetails paymentDetails,LocalDateTime bookingDateTime) {
        this.bookingId = bookingId;
        this.car = car;
        this.user = user;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.status = status;
        this.paymentDetails = paymentDetails;
        this.bookingDateTime = bookingDateTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(String bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public String getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(String bookedTo) {
        this.bookedTo = bookedTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }
}