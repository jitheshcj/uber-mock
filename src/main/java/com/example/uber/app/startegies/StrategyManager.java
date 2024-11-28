package com.example.uber.app.startegies;

import com.example.uber.app.startegies.impl.DriverMatchingHighestRatedStrategy;
import com.example.uber.app.startegies.impl.DriverMatchingNearestDriverStrategy;
import com.example.uber.app.startegies.impl.RideFareSurgeDefaultFareCalculationStrategy;
import com.example.uber.app.startegies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class StrategyManager {
    private final DriverMatchingHighestRatedStrategy driverMatchingHighestRatedStrategy;
    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;
    private final RideFareSurgeDefaultFareCalculationStrategy rideFareSurgeDefaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if(riderRating>=4.8){
            return driverMatchingHighestRatedStrategy;
        }
        return driverMatchingNearestDriverStrategy;
    }
    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        LocalTime SURGE_START_TIME=LocalTime.of(18,0);
        LocalTime SURGE_END_TIME=LocalTime.of(21,0);
        LocalTime currentTime=LocalTime.now();
        if(currentTime.isAfter(SURGE_START_TIME) && currentTime.isBefore(SURGE_END_TIME)){
            return rideFareSurgePricingFareCalculationStrategy;
        }
        return rideFareSurgeDefaultFareCalculationStrategy;
    }
}
