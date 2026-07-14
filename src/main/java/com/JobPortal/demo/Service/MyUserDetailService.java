package com.JobPortal.demo.Service;

import com.JobPortal.demo.Model.User;
import com.JobPortal.demo.Model.UserPrincipal;
import com.JobPortal.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= repo.findByUsername(username);

       if(user==null){
           throw  new UsernameNotFoundException("404 Not project");
       }
       else {
           return new UserPrincipal(user);
       }
    }
}
