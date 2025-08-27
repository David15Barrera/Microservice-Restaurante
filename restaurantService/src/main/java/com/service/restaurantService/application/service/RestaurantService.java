package com.service.restaurantService.application.service;

import com.service.restaurantService.application.dto.RestaurantDTO;
import com.service.restaurantService.domain.model.Restaurant;
import com.service.restaurantService.domain.port.out.RestaurantRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantService {
    private final RestaurantRepositoryPort repository;

    public RestaurantService(RestaurantRepositoryPort repository) {
        this.repository = repository;
    }

    public RestaurantDTO create(RestaurantDTO dto) {
        Restaurant saved = repository.save(map(dto));
        return map(saved);
    }

    public RestaurantDTO update(UUID id, RestaurantDTO dto) {
        Restaurant existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found: " + id));
        Restaurant toSave = map(dto);
        toSave.setId(id);
        return map(repository.save(toSave));
    }

    public RestaurantDTO get(UUID id) {
        return repository.findById(id).map(this::map)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found: " + id));
    }

    public List<RestaurantDTO> list() {
        return repository.findAll().stream().map(this::map).toList();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private Restaurant map(RestaurantDTO dto) {
        return new Restaurant(dto.id(), dto.name(), dto.hotelId(), dto.address(), dto.phone(),
                dto.capacity(), dto.openingTime(), dto.closingTime());
    }
    private RestaurantDTO map(Restaurant model) {
        return new RestaurantDTO(model.getId(), model.getName(), model.getHotelId(), model.getAddress(),
                model.getPhone(), model.getCapacity(), model.getOpeningTime(), model.getClosingTime());
    }
}
