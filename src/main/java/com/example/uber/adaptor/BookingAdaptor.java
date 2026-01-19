package com.example.uber.adaptor;

import com.example.uber.dto.BookingRequest;
import com.example.uber.dto.BookingResponse;
import com.example.uber.entity.Booking;
import com.example.uber.entity.Driver;
import com.example.uber.entity.Passenger;
import org.springframework.stereotype.Component;

@Component
public class BookingAdaptor {

    public Booking toEntity(BookingRequest bookingRequest, Passenger passenger, Driver driver)
    {
        Booking.BookingStatus status = driver != null ? Booking.BookingStatus.CONFIRMED : Booking.BookingStatus.PENDING;

        return Booking.builder().
                passenger(passenger)
                .driver(driver)
                .pickupLocation(bookingRequest.getPickupLocation())
                .dropoffLocation(bookingRequest.getDropoffLocation())
                .fare(bookingRequest.getFare())
                .status(status)
                .scheduledPickupTime(bookingRequest.getScheduledPickupTime())
                .build();
    }

    public BookingResponse toResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .passengerId(booking.getPassenger() != null ? booking.getPassenger().getId() : null)
                .passengerName(booking.getPassenger() != null ? booking.getPassenger().getName() : null)
                .driverId(booking.getDriver() != null ? booking.getDriver().getId() : null)
                .driverName(booking.getDriver() != null ? booking.getDriver().getName() : null)
                .pickupLocation(booking.getPickupLocation())
                .dropoffLocation(booking.getDropoffLocation())
                .status(booking.getStatus())
                .fare(booking.getFare())
                .createdAt(booking.getCreatedAt())
                .updatedAt(booking.getUpdatedAt())
                .scheduledPickupTime(booking.getScheduledPickupTime())
                .actualPickupTime(booking.getActualPickupTime())
                .completedAt(booking.getCompletedAt())
                .build();
    }


    public void updateEntity(Booking booking, BookingRequest request, Passenger passenger, Driver driver) {
        booking.setPassenger(passenger);
        booking.setDriver(driver);
        booking.setPickupLocation(request.getPickupLocation());
        booking.setDropoffLocation(request.getDropoffLocation());
        booking.setFare(request.getFare());
        booking.setScheduledPickupTime(request.getScheduledPickupTime());

        if (driver != null && booking.getStatus() == Booking.BookingStatus.PENDING) {
            booking.setStatus(Booking.BookingStatus.CONFIRMED);
        }
    }
}
