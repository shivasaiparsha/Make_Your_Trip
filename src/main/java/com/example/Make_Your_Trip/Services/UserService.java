package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Models.User;
import com.example.Make_Your_Trip.Repositories.UserRepository;
import com.example.Make_Your_Trip.RequestDto.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;
    public String addUser(AddUserDto addUserDto) {

        User user =User.builder().age(addUserDto.getAge())
                .name(addUserDto.getName())
                .emailId(addUserDto.getEmailId())
                .build();

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        String body="Hi Welcome to MakeYourTrip \n"+"Make Youre Tours plans Here";
        mailMessage.setSubject("Make Your Trip");
        mailMessage.setFrom("xyz@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setText(body);
        mailSender.send(mailMessage);

       return "User Successfully added";

    }
}
