package com.example.uber.app.repositories;

import com.example.uber.app.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    @Query(value = "SELECT d.*,ST_Distance(d.current_location, :pickUpLocation) as distance " +
            "FROM driver  d " +
            "where available = true AND ST_DWithin(d.current_location,:pickUpLocation,10000) " +
            "ORDER BY distance " +
            "LIMIT 10",nativeQuery = true)
    List<Driver> findTenNearestDrivers(Point pickUpLocation);

    @Query(value = "SELECT d.*,ST_Distance(d.current_location, :pickUpLocation) as distance " +
            "FROM driver  d " +
            "where d.available = true AND ST_DWithin(d.current_location,:pickUpLocation,10000) " +
            "ORDER BY d.rating desc ,distance " +
            "LIMIT 10",nativeQuery = true)
    List<Driver> findTenHighestRatedDriver(Point pickUpLocation);
}
