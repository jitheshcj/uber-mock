package com.example.uber.app.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
public class ApiError {
    private String error;
    private List<String> subError;
    private HttpStatus httpStatus;
}
