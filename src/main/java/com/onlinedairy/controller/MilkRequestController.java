package com.onlinedairy.controller;

import com.onlinedairy.dto.FarmerEmailDto;
import com.onlinedairy.dto.MilkRequestInputDto;
import com.onlinedairy.dto.MilkRequestResponseDto;
import com.onlinedairy.model.MilkRequest;
import com.onlinedairy.service.MilkRequestService;
import com.onlinedairy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/milk-requests")
public class MilkRequestController {
    @Autowired
    private MilkRequestService milkRequestService;


    @Autowired
    private UserService userService;
    @GetMapping("/hey")
    public String hello() {
        return "helo";
    }
    // Fetch milk requests by farmer email
//    @PostMapping("/farmer")
//    public ResponseEntity<List<MilkRequest>> getMilkRequestsByFarmerEmail(@RequestBody String email) {
//        return ResponseEntity.ok(milkRequestService.getMilkRequestsByFarmerEmail(email));
//    }
    @PostMapping("/farmer")
    public ResponseEntity<List<MilkRequest>> getMilkRequestsByFarmerEmail(@RequestBody FarmerEmailDto farmerEmailDto) {
        return ResponseEntity.ok(milkRequestService.getMilkRequestsByFarmerEmail(farmerEmailDto.getEmail()));
    }




        // Endpoint to fetch all milk requests as DTOs
        @GetMapping("/getall")
        public ResponseEntity<List<MilkRequestResponseDto>> getAllMilkRequests() {
            List<MilkRequestResponseDto> milkRequestDtos = milkRequestService.getAllMilkRequestsAsDto();
            return ResponseEntity.ok(milkRequestDtos);
        }

        // Endpoint to add a new milk request
        @PostMapping("/add")
        public ResponseEntity<?> addMilkRequest(@RequestBody MilkRequestInputDto milkRequestInputDto) {
            try {
                MilkRequest savedRequest = milkRequestService.saveMilkRequestFromDto(milkRequestInputDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedRequest);
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
    }


