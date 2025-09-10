package com.service.restaurantService.restaurant.infrastructure.outputadapter.feign;

import com.service.restaurantService.restaurant.application.ports.output.FindHotelOutputPort;
import com.service.restaurantService.restaurant.domain.model.HotelDomainEntity;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.dto.HotelResponse;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.HotelFeign.HotelFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class HotelFeignOutputAdapter implements FindHotelOutputPort {

    private final HotelFeignClient client;

    public HotelFeignOutputAdapter(HotelFeignClient client){
        this.client = client;
    }

    @Override
    public HotelDomainEntity findById(UUID id) {
        HotelResponse response = client.getHotelById(UUID.fromString(id.toString()));

        HotelDomainEntity domain = new HotelDomainEntity();
        domain.setId(response.id);
        domain.setName(response.name);
        domain.setAddress(response.address);
        domain.setPhone(response.phone);
        domain.setTotalRooms(response.totalRooms);

        return domain;
    }
}
