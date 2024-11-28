package com.example.uber.app.annotations.impl;

import com.example.uber.app.annotations.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidatorImpl implements ConstraintValidator<PasswordValidator,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length()>5;
    }
}
