package com.onlinedairy.dto;

import com.onlinedairy.model.AppUser;

import java.time.LocalDateTime;

public class MilkRequestInputDto {

    private LocalDateTime date;
    private double liters;
    private double fatPercentage;
    private double proteinPercentage;
    private double waterContent;
    private double pricePerLiter;
    private double totalPrice;
    private String paymentMethod;
    private AppUser farmer; // Farmer details moved above employee
    private String employee;

    // Getters and Setters
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

    public AppUser getFarmer() {
        return farmer;
    }

    public void setFarmer(AppUser farmer) {
        this.farmer = farmer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}