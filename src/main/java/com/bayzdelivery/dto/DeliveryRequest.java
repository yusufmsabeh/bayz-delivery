package com.bayzdelivery.dto;

import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.repositories.PersonRepository;
import com.bayzdelivery.service.PersonService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class DeliveryRequest {

    @NotNull(message = "Delivery man ID cannot be null")
    @Positive(message = "Delivery man ID must be a positive number.")
    private Long deliveryManId;


    @NotNull(message = "customer ID cannot be null")
    @Positive(message = "customer ID must be a positive number.")
    private Long customerId;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive number.")
    private Long price;

    @NotNull(message = "Distance cannot be null")
    @Positive(message = "Distance must be a positive number.")
    private Long distance;


    private Instant startTime;
    private Instant endTime;

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Long getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(Long deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }
    public Delivery getInstance(){
        Delivery delivery = new Delivery();
        delivery.setDistance(this.distance);
        delivery.setStartTime(this.startTime);
        delivery.setEndTime(this.endTime);
        delivery.setPrice(this.price);
        return delivery;
    }
}
