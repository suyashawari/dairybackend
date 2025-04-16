//package com.onlinedairy.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import lombok.Data;
//import java.time.LocalDateTime;

//@Entity
//@Table(name = "milk_request")
//public class MilkRequest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Version // Optimistic Lock tracking
//    private int version;
//
//
//    private LocalDateTime date;
//    private double liters;
//    private double fatPercentage;
//    private double proteinPercentage;
//    private double waterContent;
//    private double pricePerLiter;
//    private double totalPrice;
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
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public double getLiters() {
//        return liters;
//    }
//
//    public void setLiters(double liters) {
//        this.liters = liters;
//    }
//
//    public double getFatPercentage() {
//        return fatPercentage;
//    }
//
//    public void setFatPercentage(double fatPercentage) {
//        this.fatPercentage = fatPercentage;
//    }
//
//    public double getProteinPercentage() {
//        return proteinPercentage;
//    }
//
//    public void setProteinPercentage(double proteinPercentage) {
//        this.proteinPercentage = proteinPercentage;
//    }
//
//    public double getWaterContent() {
//        return waterContent;
//    }
//
//    public void setWaterContent(double waterContent) {
//        this.waterContent = waterContent;
//    }
//
//    public double getPricePerLiter() {
//        return pricePerLiter;
//    }
//
//    public void setPricePerLiter(double pricePerLiter) {
//        this.pricePerLiter = pricePerLiter;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
//    public String getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(String employee) {
//        this.employee = employee;
//    }
//
//    public AppUser getFarmer() {
//        return farmer;
//    }
//
//    public void setFarmer(AppUser farmer) {
//        this.farmer = farmer;
//    }
//
//    private String paymentMethod;
//    private String employee;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "farmer_id", nullable = false)
//    @JsonBackReference
//    private AppUser farmer;
//
//    // Getters and setters...
//}



package com.onlinedairy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Table(name = "milk_request")
public class MilkRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private double liters;
    private double fatPercentage;
    private double proteinPercentage;
    private double waterContent;
    private double pricePerLiter;
    private double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public double getProteinPercentage() {
        return proteinPercentage;
    }

    public void setProteinPercentage(double proteinPercentage) {
        this.proteinPercentage = proteinPercentage;
    }

    public double getWaterContent() {
        return waterContent;
    }

    public void setWaterContent(double waterContent) {
        this.waterContent = waterContent;
    }

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    private String paymentMethod;
    private String farmerEmail; // Farmer email stored for reference
    private String employee;

    // Getters and Setters
    // ...
}