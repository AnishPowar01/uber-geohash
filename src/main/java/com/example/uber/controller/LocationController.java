package com.example.uber.controller;

import com.example.uber.dto.DriverLocationDto;
import com.example.uber.dto.NearbyRequestDto;
import com.example.uber.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/driverLocation")
    public ResponseEntity<Boolean> saveDriverLocation(@RequestBody DriverLocationDto locationDto) {
        Boolean result = locationService.saveDriverLocation(locationDto.getDriverId(), locationDto.getLatitude(), locationDto.getLongitude());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/nearbyDrivers")
    public ResponseEntity<List<DriverLocationDto>> getNearbyDrivers(@RequestBody NearbyRequestDto dto) {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                locationService.getNearbyDrivers(dto.getLatitude(), dto.getLongitude(), dto.getRadius())
        );
    }


}
