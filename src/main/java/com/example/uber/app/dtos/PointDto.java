package com.example.uber.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDto {
    private double[] coordinates;
    private String type="Point";

    public PointDto(double[] coordinates){
        this.coordinates=coordinates;
    }
}
