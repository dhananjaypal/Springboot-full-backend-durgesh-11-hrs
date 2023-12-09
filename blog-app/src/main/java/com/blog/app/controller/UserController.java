package com.blog.app.controller;

import com.blog.app.payloads.ApiResponse;
import com.blog.app.payloads.UserDto;
import com.blog.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Add User
    @PostMapping(path = "/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser = this.userService.createUser(userDto);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    //Update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId){

        UserDto updateUser = this.userService.update(userDto,userId);
        return  ResponseEntity.ok(updateUser);
    }

    //Delete User

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully",true), HttpStatus.OK);
    }

    //Get user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }


}
