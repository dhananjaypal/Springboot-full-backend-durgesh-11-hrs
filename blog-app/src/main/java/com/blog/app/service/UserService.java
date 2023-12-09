package com.blog.app.service;

import com.blog.app.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto update(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer UserId);
}
