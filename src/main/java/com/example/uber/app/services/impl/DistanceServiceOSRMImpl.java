package com.example.uber.app.services.impl;

import com.example.uber.app.services.DistanceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistanceServiceOSRMImpl implements DistanceService {

    private final RestClient restClient;

    @Override
    public double calculateDistance(Point src, Point des) {
        try {
            OSRMResponseDto osrmResponseDto=restClient.get()
                    .uri(src.getX()+","+src.getY()+";"+des.getX()+","+des.getY())
                    .retrieve()
                    .body(OSRMResponseDto.class);
            return osrmResponseDto
                    .getRoutes()
                    .get(0)
                    .getDistance()/1000.0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting data form OSRM "+e.getLocalizedMessage());
        }
    }
}

@Data
class OSRMResponseDto{
    private List<OSRMRoutes> routes;
}

@Data
class OSRMRoutes {
    private Double distance;
}