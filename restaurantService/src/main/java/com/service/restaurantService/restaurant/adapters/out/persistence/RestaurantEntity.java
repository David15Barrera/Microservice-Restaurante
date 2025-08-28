package com.service.restaurantService.restaurant.adapters.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name="name", length=100, nullable=false)
    private String name;

    @Column(name="hotel_id", columnDefinition = "uuid")
    private UUID hotelId;

    @Column(name="address")
    private String address;

    @Column(name="phone", length=20, nullable=false)
    private String phone;

    @Column(name="capacity")
    private Integer capacity;

    @Column(name="opening_time")
    private LocalTime openingTime;

    @Column(name="closing_time")
    private LocalTime closingTime;

    @Column(name="created_at")
    private java.time.LocalDateTime createdAt;

    // getters/setters
    public UUID getId() {
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

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime t) {
        this.createdAt = t;
    }
}
