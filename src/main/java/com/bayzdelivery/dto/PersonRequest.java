package com.bayzdelivery.dto;

import com.bayzdelivery.model.Person;
import com.bayzdelivery.model.TypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonRequest {

    @NotBlank(message = "Name cannot be null")
    @Size(min = 3,max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be a valid email address")
    private String email;

    @NotNull(message = "Type cannot be null")
    private TypeEnum type;

    private String registrationNumber;

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

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public Person getInstance(){
        Person person = new Person();
        person.setName(this.name);
        person.setEmail(this.email);
        person.setType(this.type);
        person.setRegistrationNumber(this.registrationNumber);
        return person;
    }
}
