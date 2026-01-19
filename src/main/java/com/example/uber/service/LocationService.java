package com.example.uber.service;

import com.example.uber.dto.DriverLocationDto;

import java.util.List;

public interface LocationService {

    Boolean saveDriverLocation(String driverId, Double latitude, Double longitude);
    List<DriverLocationDto> getNearbyDrivers(Double latitude, Double longitude, Double radius);
}
