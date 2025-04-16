package com.onlinedairy.controller;

import com.onlinedairy.model.AppUser;
import com.onlinedairy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/users/data/")
public class UserDataController {

    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // Endpoint to get all farmers
    @GetMapping("/farmers")
    public ResponseEntity<List<AppUser>> getAllFarmers() {
        return userService.getAllFarmers();
    }

    // Endpoint to get all employees
    @GetMapping("/employees")
    public ResponseEntity<List<AppUser>> getAllEmployees() {
        return userService.getAllEmployees();
    }
}