package com.bayzdelivery.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bayzdelivery.dto.Top3DeliveryMenResponse;
import com.bayzdelivery.dto.PersonRequest;
import com.bayzdelivery.model.StatusEnum;
import com.bayzdelivery.repositories.PersonRepository;
import com.bayzdelivery.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    public Person save(PersonRequest p) {
        Person person = new Person();
        person.setName(p.getName());
        person.setEmail(p.getEmail());
        person.setStatus(StatusEnum.FREE);
        person.setType(p.getType());
        person.setRegistrationNumber(p.getRegistrationNumber());
        return personRepository.save(person);
    }
    @Override
    public List<Top3DeliveryMenResponse> getTop3DeliveryMen(Instant startDate, Instant endDate){
        return personRepository.getTop3DeliveryMenCommission(startDate, endDate);
    }
    @Override
    public Person findById(Long personId) {
        Optional<Person> dbPerson = personRepository.findById(personId);
        return dbPerson.orElse(null);
    }
}
