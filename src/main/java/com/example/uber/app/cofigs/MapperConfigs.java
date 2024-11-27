package com.example.uber.app.cofigs;

import com.example.uber.app.dtos.PointDto;
import com.example.uber.app.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigs {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper=new ModelMapper();
         modelMapper.typeMap(PointDto.class, Point.class)
                 .setConverter(converter->{
                     PointDto pointDto=converter.getSource();
                     return GeometryUtil.createAPoint(pointDto);
                 });

         modelMapper.typeMap(Point.class,PointDto.class)
                 .setConverter(mappingContext -> {
                     Point point= mappingContext.getSource();
                     double[] points ={point.getX(), point.getY()};
                     return new PointDto(points);
                 });
        return modelMapper;
    }
}
