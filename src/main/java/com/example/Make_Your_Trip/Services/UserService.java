package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Models.User;
import com.example.Make_Your_Trip.Repositories.UserRepository;
import com.example.Make_Your_Trip.RequestDto.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserDto addUserDto) {

        User user =User.builder().age(addUserDto.getAge())
                .name(addUserDto.getName())
                .emailId(addUserDto.getEmailId())
                .build();
        userRepository.save(user);

  return "User Successfully added";
    }
}
