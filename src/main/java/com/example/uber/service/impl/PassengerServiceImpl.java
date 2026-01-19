package com.example.uber.service.impl;

import com.example.uber.dto.PassengerRequest;
import com.example.uber.dto.PassengerResponse;
import com.example.uber.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    @Override
    public Optional<PassengerResponse> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PassengerResponse> findAll() {
        return List.of();
    }

    @Override
    public Optional<PassengerResponse> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public PassengerResponse create(PassengerRequest request) {
        return null;
    }

    @Override
    public PassengerResponse update(Long id, PassengerRequest request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
