package com.example.uber.service.read;

import com.example.uber.dto.BookingResponse;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookingReadService {
    Optional<BookingResponse> findById(Long id);
    List<BookingResponse> findAll();
    List<BookingResponse> findByPassengerId(Long passengerId);
    List<BookingResponse> findByDriverId(Long driverId);

}
