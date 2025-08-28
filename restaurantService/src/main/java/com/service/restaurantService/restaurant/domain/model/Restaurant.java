package com.service.restaurantService.restaurant.domain.model;

import java.time.LocalTime;
import java.util.UUID;

public class Restaurant {
    private UUID id;
    private String name;
    private UUID hotelId;
    private String address;
    private String phone;
    private Integer capacity;
    private LocalTime openingTime;
    private LocalTime closingTime;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID h) {
        this.hotelId = h;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        this.address = a;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String p) {
        this.phone = p;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer c) {
        this.capacity = c;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime t) {
        this.openingTime = t;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime t) {
        this.closingTime = t;
    }
}
