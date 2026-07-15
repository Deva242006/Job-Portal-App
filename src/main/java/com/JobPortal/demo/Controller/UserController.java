package com.JobPortal.demo.Controller;

import com.JobPortal.demo.Model.User;
import com.JobPortal.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @PostMapping("/Register")
    public User save(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return service.Save(user);
    }
}
