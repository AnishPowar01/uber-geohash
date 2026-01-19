package com.example.uber.service.write;

import com.example.uber.dto.DriverRequest;
import com.example.uber.dto.DriverResponse;

public interface DriverWriteService {
    DriverResponse create(DriverRequest request);
    DriverResponse update(Long id, DriverRequest request);
    void deleteById(Long id);
}
