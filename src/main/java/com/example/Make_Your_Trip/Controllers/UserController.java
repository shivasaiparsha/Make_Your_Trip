package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDto.AddUserDto;
import com.example.Make_Your_Trip.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody AddUserDto addUserDto)
    {
        String message= userService.addUser(addUserDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
