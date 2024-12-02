package com.example.uber.app.repositories;

import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.Ride;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride,Long> {
    List<Ride> findByDriver(Driver driver, Pageable pageable);
}
