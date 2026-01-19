package com.example.uber.service.read;

import com.example.uber.dto.DriverResponse;

import java.util.List;
import java.util.Optional;

public interface DriverReadService {
    Optional<DriverResponse> findById(Long id);
    List<DriverResponse> findAll();
    Optional<DriverResponse> findByEmail(String email);
    List<DriverResponse> findAvailableDrivers();
}
