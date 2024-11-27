package com.example.uber.app.utils;

import com.example.uber.app.dtos.PointDto;
import org.locationtech.jts.geom.*;

public class GeometryUtil {

    public static Point createAPoint(PointDto pointDto){
        GeometryFactory factory=new GeometryFactory(new PrecisionModel(),4326);
        Coordinate coordinate= new Coordinate(pointDto.getCoordinates()[0],pointDto.getCoordinates()[1]);
        return factory.createPoint(coordinate);
    }
}
