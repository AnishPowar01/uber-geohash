package com.example.uber.service.write;

import com.example.uber.dto.PassengerRequest;
import com.example.uber.dto.PassengerResponse;

public interface PassengerWriteService {
    PassengerResponse create(PassengerRequest request);
    PassengerResponse update(Long id, PassengerRequest request);
    void deleteById(Long id);
}
