package com.blog.app.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.PrimitiveIterator;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters")
    private String name;

    @Email(message = "Email is not a valid email.")
    private String email;

    @NotEmpty
    @Size(min = 5, max = 10, message = "Password must be min 5 characters and max 10 characters")
    private String password;

    @NotEmpty
    @Size(max = 200, message = "About must be less than 200 of characters")
    private String about;

}
