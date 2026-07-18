package com.JobPortal.demo.Service;

import com.JobPortal.demo.Model.User;
import com.JobPortal.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public User Save(User user){
        return repo.save(user);
    }

    public List<User> getuser() {

        return repo.findAll();
    }

    public User updateUser(User user) {


       return  repo.save(user);





    }
}
