package com.example.uber.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NearbyRequestDto {
    private Double latitude;
    private Double longitude;
    private Double radius;
}
