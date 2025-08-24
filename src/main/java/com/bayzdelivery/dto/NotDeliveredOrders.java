package com.bayzdelivery.dto;

import java.time.Instant;

public class NotDeliveredOrders {
    private Long id;

    public Instant startTime;

    public NotDeliveredOrders(Long id , Instant endTime) {
        this.startTime = endTime;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }
}
