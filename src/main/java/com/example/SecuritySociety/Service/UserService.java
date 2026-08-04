package com.example.SecuritySociety.Service;

import com.example.SecuritySociety.Entity.User;
import com.example.SecuritySociety.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User getUser(String user){
        return userRepo.findByName(user);
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }
}
