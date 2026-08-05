package com.example.SecuritySociety.Service;

import com.example.SecuritySociety.Entity.User;
import com.example.SecuritySociety.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User getUser(String user){
        return userRepo.findByName(user);
    }

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }
}
