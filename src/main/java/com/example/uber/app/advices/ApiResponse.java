package com.example.uber.app.advices;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private ApiError apiError;
    private T data;
    {
        timestamp=LocalDateTime.now();
    }
    public ApiResponse(T data){
        this.data=data;
    }
    public ApiResponse(ApiError apiError){
        this.apiError=apiError;
    }
}
