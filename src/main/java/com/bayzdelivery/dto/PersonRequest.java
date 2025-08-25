package com.bayzdelivery.dto;

import com.bayzdelivery.model.Person;
import com.bayzdelivery.model.TypeEnum;

public class PersonRequest {
    private String name;
    private String email;
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
