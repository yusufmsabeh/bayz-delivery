package com.bayzdelivery.dto;

public class Top3DeliveryMenResponse {
    public Top3DeliveryMenResponse(Long id, String name, String email, String registrationNumber, double totalCommission, double averageCommission) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationNumber = registrationNumber;
        this.totalCommission = totalCommission;
        this.averageCommission = averageCommission;
    }

    private Long id;
    private String name;
    private String email;
    private String registrationNumber;
    private double totalCommission;
    private double averageCommission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public double getAverageCommission() {
        return averageCommission;
    }

    public void setAverageCommission(double averageCommission) {
        this.averageCommission = averageCommission;
    }
}
