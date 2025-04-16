package com.onlinedairy.service;

import com.onlinedairy.model.AppUser;
import com.onlinedairy.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private AppUserRepository userRepository;

    public ResponseEntity<?> addFarmer(AppUser user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A user with this email already exists.");
        }


//        if (user.getId() != null) {
//            // Clear ID to ensure auto-generation is used
//            user.setId(null);
//        }


        // Add role to user
        user.setRole("ROLE_FARMER");

        // Ensure bank details are not null
        if (user.getBankDetails() == null || user.getBankDetails().getAccountHolder() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Bank details are missing or incomplete for the user.");
        }

        // Save the user along with the embedded bank details
        AppUser savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }



    public ResponseEntity<?> addEmployee(AppUser user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A user with this email already exists.");
        }
        if (user.getId() != null) {
            // Clear ID to ensure auto-generation is used
            user.setId(null);
        }

        // Add role to user
        user.setRole("ROLE_EMPLOYEE");

        // Ensure bank details are not null
        if (user.getBankDetails() == null || user.getBankDetails().getAccountHolder() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Bank details are missing or incomplete for the user.");
        }

        // Save the user along with the embedded bank details
        AppUser savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    public ResponseEntity<?> addManager(AppUser user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A user with this email already exists.");
        }

        // Add role to user
        user.setRole("ROLE_MANAGER");

        // Ensure bank details are not null
        if (user.getBankDetails() == null || user.getBankDetails().getAccountHolder() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Bank details are missing or incomplete for the user.");
        }

        // Save the user along with the embedded bank details
        AppUser savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    public ResponseEntity<?> validateUser(String email, String password) {
        Optional<AppUser> user = userRepository.findByEmailAndPassword(email, password);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
    }

    public ResponseEntity<List<AppUser>> getAllFarmers() {
        // Fetch all farmers where role is ROLE_FARMER
        List<AppUser> farmers = userRepository.findAll()
                .stream()
                .filter(user -> "ROLE_FARMER".equals(user.getRole()))
                .toList();

        return ResponseEntity.ok(farmers);
    }

    // Method to get all employees
    public ResponseEntity<List<AppUser>> getAllEmployees() {
        // Fetch all employees where role is ROLE_EMPLOYEE
        List<AppUser> employees = userRepository.findAll()
                .stream()
                .filter(user -> "ROLE_EMPLOYEE".equals(user.getRole()))
                .toList();

        return ResponseEntity.ok(employees);
    }

}