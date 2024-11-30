package com.example.uber.app.annotations;

import com.example.uber.app.annotations.impl.PasswordValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = PasswordValidatorImpl.class)
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface PasswordValidator {
    String message() default "Invalid password";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
