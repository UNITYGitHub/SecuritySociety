package com.example.SecuritySociety.Controller;

import com.example.SecuritySociety.Entity.DTO.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest user) {
        System.out.println(user.toString());
        return ResponseEntity.ok().body("Login Successful");
    }
}
