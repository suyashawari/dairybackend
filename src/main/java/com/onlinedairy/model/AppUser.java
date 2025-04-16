package com.onlinedairy.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

//@Entity
//@Table(name = "app_user")
//public class AppUser {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Version // Optional for AppUser if updated concurrently
//    private int version;
//
//    private String name;
//    private String email;
//    private String phoneNumber;
//    private String address;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public int getVersion() {
//        return version;
//    }
//
//    public void setVersion(int version) {
//        this.version = version;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public BankDetails getBankDetails() {
//        return bankDetails;
//    }
//
//    public void setBankDetails(BankDetails bankDetails) {
//        this.bankDetails = bankDetails;
//    }
//
//    public List<MilkRequest> getMilkRequests() {
//        return milkRequests;
//    }
//
//    public void setMilkRequests(List<MilkRequest> milkRequests) {
//        this.milkRequests = milkRequests;
//    }
//
//    private String password;
//    private String role;
//
//    @Embedded
//    private BankDetails bankDetails;
//
//
//
//    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference  // Prevents infinite recursion
//    private List<MilkRequest> milkRequests;
//}
@Entity
@Table(name = "app_user")
public class AppUser {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String role;

    @Embedded
    private BankDetails bankDetails;

    // Getters and Setters
    // ...
}