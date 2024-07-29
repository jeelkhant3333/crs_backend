package com.techspine.crs.request;

import com.techspine.crs.entity.PaymentDetails;


public class BookingRequest {
    private Integer carId;
    private String BookedFrom;
    private String BookedTo;
    private PaymentDetails paymentDetails;

    public BookingRequest() {
    }

    public BookingRequest(Integer carId, String bookedFrom, String bookedTo, PaymentDetails paymentDetails) {
        this.carId = carId;
        BookedFrom = bookedFrom;
        BookedTo = bookedTo;
        this.paymentDetails = paymentDetails;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBookedFrom() {
        return BookedFrom;
    }

    public void setBookedFrom(String bookedFrom) {
        BookedFrom = bookedFrom;
    }

    public String getBookedTo() {
        return BookedTo;
    }

    public void setBookedTo(String bookedTo) {
        BookedTo = bookedTo;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
