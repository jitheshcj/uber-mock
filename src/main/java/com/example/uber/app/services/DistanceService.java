package com.example.uber.app.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    double calculateDistance(Point src, Point des);
}
