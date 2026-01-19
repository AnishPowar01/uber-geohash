package com.example.uber.service.write;

import com.example.uber.dto.BookingRequest;
import com.example.uber.dto.BookingResponse;
import com.example.uber.entity.Booking;
import org.springframework.stereotype.Service;

public interface BookingWriteService {
    BookingResponse create(BookingRequest request);
    BookingResponse update(Long id, BookingRequest request);
    BookingResponse updateStatus(Long id, Booking.BookingStatus status);
    void deleteById(Long id);
}
