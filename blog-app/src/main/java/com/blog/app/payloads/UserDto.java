package com.blog.app.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.PrimitiveIterator;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String about;

}
