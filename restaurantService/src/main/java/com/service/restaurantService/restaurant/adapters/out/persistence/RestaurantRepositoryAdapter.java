package com.service.restaurantService.restaurant.adapters.out.persistence;

import com.service.restaurantService.restaurant.domain.model.Restaurant;
import com.service.restaurantService.restaurant.domain.port.RestaurantRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantRepositoryAdapter implements RestaurantRepositoryPort {

    private final RestaurantJpaRepository jpa;

    public RestaurantRepositoryAdapter(RestaurantJpaRepository jpa) { this.jpa = jpa; }

    private static Restaurant toDomain(RestaurantEntity e){
        if(e==null) return null;
        Restaurant r = new Restaurant();
        r.setId(e.getId());
        r.setName(e.getName());
        r.setHotelId(e.getHotelId());
        r.setAddress(e.getAddress());
        r.setPhone(e.getPhone());
        r.setCapacity(e.getCapacity());
        r.setOpeningTime(e.getOpeningTime());
        r.setClosingTime(e.getClosingTime());
        return r;
    }

    private static RestaurantEntity toEntity(Restaurant r){
        if(r==null) return null;
        RestaurantEntity e = new RestaurantEntity();
        e.setId(r.getId());
        e.setName(r.getName());
        e.setHotelId(r.getHotelId());
        e.setAddress(r.getAddress());
        e.setPhone(r.getPhone());
        e.setCapacity(r.getCapacity());
        e.setOpeningTime(r.getOpeningTime());
        e.setClosingTime(r.getClosingTime());
        return e;
    }

    @Override
    public Restaurant save(Restaurant r){
        return toDomain(jpa.save(toEntity(r)));
    }

    @Override
    public Optional<Restaurant> findById(UUID id){
        return jpa.findById(id).map(RestaurantRepositoryAdapter::toDomain);
    }

    @Override
    public List<Restaurant> findAll(){
        return jpa.findAll().stream().map(RestaurantRepositoryAdapter::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id){
        jpa.deleteById(id);
    }
}
