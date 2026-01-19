package com.example.uber.service.impl;

import com.example.uber.dto.DriverRequest;
import com.example.uber.dto.DriverResponse;
import com.example.uber.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    @Override
    public Optional<DriverResponse> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<DriverResponse> findAll() {
        return List.of();
    }

    @Override
    public Optional<DriverResponse> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<DriverResponse> findAvailableDrivers() {
        return List.of();
    }

    @Override
    public DriverResponse create(DriverRequest request) {
        return null;
    }

    @Override
    public DriverResponse update(Long id, DriverRequest request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
