package com.service.restaurantService.domain.model;

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

    public Restaurant() {}

    public Restaurant(UUID id, String name, UUID hotelId, String address, String phone, Integer capacity,
                      LocalTime openingTime, LocalTime closingTime) {
        this.id = id;
        this.name = name;
        this.hotelId = hotelId;
        this.address = address;
        this.phone = phone;
        this.capacity = capacity;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public UUID getHotelId() { return hotelId; }
    public void setHotelId(UUID hotelId) { this.hotelId = hotelId; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public LocalTime getOpeningTime() { return openingTime; }
    public void setOpeningTime(LocalTime openingTime) { this.openingTime = openingTime; }
    public LocalTime getClosingTime() { return closingTime; }
    public void setClosingTime(LocalTime closingTime) { this.closingTime = closingTime; }
}
