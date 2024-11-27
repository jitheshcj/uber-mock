package com.example.uber.app.advices;

import com.example.uber.app.exceptions.ResourceNotFoundException;
import com.example.uber.app.exceptions.RuntimeConflictException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeConflictException.class)
    public ResponseEntity<ApiError> handleRuntimeConflictException(RuntimeConflictException runtimeConflictException){
        return
                new ResponseEntity<>(ApiError.builder()
                        .error("Runtime Conflict Exception")
                        .httpStatus(HttpStatus.CONFLICT)
                        .subError(List.of(runtimeConflictException.getMessage()))
                        .build(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return
                new ResponseEntity<>(ApiError.builder()
                        .error("Runtime Conflict Exception")
                        .httpStatus(HttpStatus.CONFLICT)
                        .subError(List.of(resourceNotFoundException.getMessage()))
                        .build(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ResponseEntity<>(ApiError.builder()
                .error("Method Argument Not  valid exception")
                .subError(methodArgumentNotValidException.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build(),HttpStatus.BAD_REQUEST);
    }
}
