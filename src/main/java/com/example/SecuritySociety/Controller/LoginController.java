package com.example.SecuritySociety.Controller;

import com.example.SecuritySociety.Entity.DTO.LoginRequest;
import com.example.SecuritySociety.Entity.User;
import com.example.SecuritySociety.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest user) {
        System.out.println(user.toString());
        return ResponseEntity.ok().body("Login Successful");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        return ResponseEntity.ok().body("Register Successful");
    }
}
