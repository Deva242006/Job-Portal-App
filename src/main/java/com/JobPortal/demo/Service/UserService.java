package com.JobPortal.demo.Service;

import com.JobPortal.demo.Model.User;
import com.JobPortal.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public User Save(User user){
        return repo.save(user);
    }
}
