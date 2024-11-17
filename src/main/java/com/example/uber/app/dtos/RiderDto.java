package com.example.uber.app.dtos;

import com.example.uber.app.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {
    private UserDto user;
    private Double fare;
}
