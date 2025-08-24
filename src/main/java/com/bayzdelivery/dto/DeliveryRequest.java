package com.bayzdelivery.dto;

import java.time.Instant;

public class DeliveryRequest {
    private Long deliveryManId;
    private Long customerId;

    private Long price;
    private Long distance;

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

    private Instant startTime;
    private Instant endTime;

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
}
