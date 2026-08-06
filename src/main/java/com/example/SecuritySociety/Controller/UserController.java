package com.example.SecuritySociety.Controller;

import com.example.SecuritySociety.Entity.User;
import com.example.SecuritySociety.Repository.UserRepo;
import com.example.SecuritySociety.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{user}")
    public User getUserByName(@PathVariable String user){
        return userService.getUser(user);
    }

    @PostMapping("/save")
    public User saveUser(@Valid @RequestBody User user){
        System.out.println("User saved"+user);
        return userService.saveUser(user);
    }
    @GetMapping("/allUser")
    public List<User> getAllUser(){
        return userService.findAllUser();
    }
}
