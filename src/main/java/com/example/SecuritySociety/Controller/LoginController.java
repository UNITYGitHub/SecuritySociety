package com.example.SecuritySociety.Controller;

import com.example.SecuritySociety.Entity.DTO.LoginRequest;
import com.example.SecuritySociety.Entity.User;
import com.example.SecuritySociety.Service.JWTService;
import com.example.SecuritySociety.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest user) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.username(),
                                    user.password()
                            )
                    );

            if(authentication.isAuthenticated()) {
                //userService.updateLastLoginDate(authentication.getName());
                return ResponseEntity.ok(jwtService.generateToken(user.username()));
            }

        } catch (Exception e) {
//            System.out.println("Authentication failed: " + e.getMessage()+ login);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }

//        System.out.println("Username and password are incorrect : "+login);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        return ResponseEntity.ok().body("Register Successful");
    }
}
