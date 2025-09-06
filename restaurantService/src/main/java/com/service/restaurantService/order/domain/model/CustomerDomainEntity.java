package com.service.restaurantService.order.domain.model;

import java.util.UUID;

public class CustomerDomainEntity {
    private UUID id;
    private String fullName;
    private String cui;
    private String phone;
    private String email;
    private String address;
    private Integer loyaltyPoints;

    // Getters
    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCui() {
        return cui;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
