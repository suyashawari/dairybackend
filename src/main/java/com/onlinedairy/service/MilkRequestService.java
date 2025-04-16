package com.onlinedairy.service;

import com.onlinedairy.dto.MilkRequestInputDto;
import com.onlinedairy.dto.MilkRequestResponseDto;
import com.onlinedairy.model.AppUser;
import com.onlinedairy.model.MilkRequest;
import com.onlinedairy.repository.AppUserRepository;
import com.onlinedairy.repository.MilkRequestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MilkRequestService {
    private static final int MAX_RETRIES = 3; // Retry limit for optimistic conflicts

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MilkRequestRepository milkRequestRepository;

    @Autowired
    private AppUserRepository appUserRepository;



    // Fetch all milk requests
    public List<MilkRequest> getAllMilkRequests() {
        return milkRequestRepository.findAll();
    }

    // Fetch milk requests by farmer email
    public List<MilkRequest> getMilkRequestsByFarmerEmail(String email) {
        return milkRequestRepository.findByFarmerEmail(email);
    }

    // Check if an employee name already exists
    public Optional<MilkRequest> findByEmployeeName(String employee) {
        return milkRequestRepository.findByEmployee(employee);
    }

    // Add a milk request (Find farmer by email instead of ID)
    // Add a milk request using the farmer's email from the provided full JSON
//    @Transactional
//    public MilkRequest addMilkRequest(MilkRequest milkRequest) {
//        int retryCount = 0;
//
//        while (retryCount < MAX_RETRIES) {
//            try {
//                // Fetch the farmer with a fresh reference and attach it to the persistence context
//                AppUser farmer = validateAndAttachFarmer(milkRequest.getFarmer());
//                milkRequest.setFarmer(farmer);
//
//                // Check and attach existing milk request if ID is provided
//                if (milkRequest.getId() != null) {
//                    MilkRequest existingRequest = milkRequestRepository.findById(milkRequest.getId())
//                            .orElseThrow(() -> new RuntimeException("Milk request not found."));
//                    entityManager.refresh(existingRequest); // Refresh stale data
//                }
//
//                // Save and return the milk request
//                return milkRequestRepository.save(milkRequest);
//
//            } catch (OptimisticLockException | ObjectOptimisticLockingFailureException e) {
//                retryCount++;
//                if (retryCount >= MAX_RETRIES) {
//                    throw new RuntimeException(
//                            "Milk request could not be processed due to a concurrency issue. Please try again later.",
//                            e);
//                }
//                System.out.println("Retrying due to concurrency conflict... Attempt " + retryCount);
//            }
//        }
//
//        throw new RuntimeException("Unexpected error: Retry logic failed without a clear issue.");
//    }
//
//    private AppUser validateAndAttachFarmer(AppUser farmerRequest) {
//        if (farmerRequest == null || farmerRequest.getEmail() == null) {
//            throw new RuntimeException("Farmer email is missing in the request!");
//        }
//
//        AppUser farmer = appUserRepository.findByEmail(farmerRequest.getEmail())
//                .orElseThrow(() -> new RuntimeException("Farmer with email '" + farmerRequest.getEmail() + "' not found."));
//
//        // Re-attach farmer to persistence context
//        return entityManager.merge(farmer);
//    }


    // Fetch all milk requests and convert to DTOs
    public List<MilkRequestResponseDto> getAllMilkRequestsAsDto() {
        List<MilkRequest> milkRequests = milkRequestRepository.findAll();

        return milkRequests.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Save milk request from DTO
    @Transactional
    public MilkRequest saveMilkRequestFromDto(MilkRequestInputDto input) {
        // Validate and fetch the farmer from the database
        if (input.getFarmer() == null || input.getFarmer().getEmail() == null) {
            throw new RuntimeException("Farmer details or email is missing!");
        }

        AppUser farmer = appUserRepository.findByEmail(input.getFarmer().getEmail())
                .orElseThrow(() -> new RuntimeException(
                        "Farmer with email '" + input.getFarmer().getEmail() + "' not found!"));

        // Map the input into a MilkRequest entity
        MilkRequest milkRequest = new MilkRequest();
        milkRequest.setDate(input.getDate());
        milkRequest.setLiters(input.getLiters());
        milkRequest.setFatPercentage(input.getFatPercentage());
        milkRequest.setProteinPercentage(input.getProteinPercentage());
        milkRequest.setWaterContent(input.getWaterContent());
        milkRequest.setPricePerLiter(input.getPricePerLiter());
        milkRequest.setTotalPrice(input.getTotalPrice());
        milkRequest.setPaymentMethod(input.getPaymentMethod());
        milkRequest.setEmployee(input.getEmployee());
        milkRequest.setFarmerEmail(farmer.getEmail()); // Only store the farmer's email

        // Save and return the MilkRequest
        return milkRequestRepository.save(milkRequest);
    }

    // Convert MilkRequest entity to MilkRequestResponseDto
    private MilkRequestResponseDto convertToDto(MilkRequest milkRequest) {
        MilkRequestResponseDto dto = new MilkRequestResponseDto();
        dto.setId(milkRequest.getId());
        dto.setDate(milkRequest.getDate());
        dto.setLiters(milkRequest.getLiters());
        dto.setFatPercentage(milkRequest.getFatPercentage());
        dto.setProteinPercentage(milkRequest.getProteinPercentage());
        dto.setWaterContent(milkRequest.getWaterContent());
        dto.setPricePerLiter(milkRequest.getPricePerLiter());
        dto.setTotalPrice(milkRequest.getTotalPrice());
        dto.setPaymentMethod(milkRequest.getPaymentMethod());
        dto.setEmployee(milkRequest.getEmployee());

        // Fetch and set full farmer details
        Optional<AppUser> farmer = appUserRepository.findByEmail(milkRequest.getFarmerEmail());
        farmer.ifPresent(dto::setFarmer);

        return dto;
    }


}
