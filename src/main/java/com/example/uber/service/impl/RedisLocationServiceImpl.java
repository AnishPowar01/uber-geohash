package com.example.uber.service.impl;

import com.example.uber.dto.DriverLocationDto;
import com.example.uber.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.Metrics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RedisLocationServiceImpl implements LocationService {

    private static final String DRIVER_GEO_OPS_KEY = "driver:geo";

    private final StringRedisTemplate template;

    @Override
    public Boolean saveDriverLocation(String driverId, Double latitude, Double longitude) {
        GeoOperations<String, String> geoOperations = template.opsForGeo();
        geoOperations.add(DRIVER_GEO_OPS_KEY,
                new RedisGeoCommands.GeoLocation<String>(driverId, new Point(latitude, longitude))
        );
        return true;
    }

    @Override
    public List<DriverLocationDto> getNearbyDrivers(Double latitude, Double longitude, Double radius) {
        GeoOperations<String, String> geoOperations = template.opsForGeo();
        Distance cirRadius = new Distance(radius, Metrics.KILOMETERS);
        Circle circle = new Circle(new Point(latitude, longitude), cirRadius);
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = geoOperations.radius(DRIVER_GEO_OPS_KEY, circle);

        return results.getContent().stream().
                map(
                        result -> {
                            Point point = geoOperations.position(DRIVER_GEO_OPS_KEY, result.getContent().getName()).get(0);

                            return DriverLocationDto.builder().driverId(result.getContent().getName()).
                                    latitude(point.getX()).longitude(point.getY()).build();
                        }).toList();

    }
}
