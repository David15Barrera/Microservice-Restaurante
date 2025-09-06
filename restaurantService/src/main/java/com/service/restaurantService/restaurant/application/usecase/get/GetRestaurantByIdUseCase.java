package com.service.restaurantService.restaurant.application.usecase.get;

import com.service.restaurantService.restaurant.application.ports.input.GetRestaurantByIdInputPort;
import com.service.restaurantService.restaurant.application.ports.output.FindHotelOutputPort;
import com.service.restaurantService.restaurant.application.ports.output.SaveRestaurantOutputPort;
import com.service.restaurantService.restaurant.domain.model.HotelDomainEntity;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetRestaurantByIdUseCase implements GetRestaurantByIdInputPort {

    private final SaveRestaurantOutputPort outputPort;
    private final FindHotelOutputPort HotelOutputPort;

    public GetRestaurantByIdUseCase(SaveRestaurantOutputPort outputPort,
                                    FindHotelOutputPort HotelOutputPort) {
        this.outputPort = outputPort;
        this.HotelOutputPort = HotelOutputPort;
    }

    @Override
    public RestaurantDomainEntity getById(UUID id) {
        RestaurantDomainEntity restaurant = outputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));

        HotelDomainEntity hotel = HotelOutputPort.findById(restaurant.getHotelId());

        restaurant.setHotel(hotel);

        return restaurant;
    }
}
