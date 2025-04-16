package com.onlinedairy.controller;

import com.onlinedairy.dto.LoginRequest;
import com.onlinedairy.model.AppUser;
import com.onlinedairy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/users/auth")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/hey")
    public String hello() {
        return "helo";
    }

    @PostMapping("/farmer")
    public ResponseEntity<?> createFarmer(@RequestBody AppUser user) {
        return userService.addFarmer(user);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody AppUser user) {
        return userService.addEmployee(user);
    }

    @PostMapping("/manager")
    public ResponseEntity<?> createManager(@RequestBody AppUser user) {
        return userService.addManager(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.validateUser(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
    }
}