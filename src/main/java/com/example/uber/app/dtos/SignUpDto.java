package com.example.uber.app.dtos;

import com.example.uber.app.annotations.PasswordValidator;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    @Length(min = 3,max = 10,message = "Name should be of [3,10] character")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @PasswordValidator
    private String password;
}
