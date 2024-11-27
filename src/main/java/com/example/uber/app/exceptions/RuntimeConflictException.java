package com.example.uber.app.exceptions;

public class RuntimeConflictException extends RuntimeException{
    RuntimeConflictException(String message){
        super(message);
    }
}
