package com.bayzdelivery.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

public class Top3DeliveryMenRequest {

    @NotNull(message = "Please provide a start date")
    @DateTimeFormat
    private Instant startDate;

    @NotNull(message = "Please provide a end date")
    @DateTimeFormat
    private Instant endDate;


    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

}
