package com.example.uber.service.impl;

import com.example.uber.adaptor.BookingAdaptor;
import com.example.uber.dto.BookingRequest;
import com.example.uber.dto.BookingResponse;
import com.example.uber.entity.Booking;
import com.example.uber.repository.BookingRepository;
import com.example.uber.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingAdaptor bookingAdaptor;

    @Override
    @Transactional(readOnly = true)
    public Optional<BookingResponse> findById(Long id) {
        return bookingRepository.findById(id)
                .map(bookingAdaptor::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponse> findAll() {
        return bookingRepository.findAll().stream().
                map(bookingAdaptor::toResponse).
                collect(Collectors.toList());
    }

    @Override
    public List<BookingResponse> findByPassengerId(Long passengerId) {
        return List.of();
    }

    @Override
    public List<BookingResponse> findByDriverId(Long driverId) {
        return List.of();
    }

    @Override
    public BookingResponse create(BookingRequest request) {
        return null;
    }

    @Override
    public BookingResponse update(Long id, BookingRequest request) {
        return null;
    }

    @Override
    public BookingResponse updateStatus(Long id, Booking.BookingStatus status) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
