package com.bayzdelivery.service;

import java.time.Instant;
import java.util.List;

import com.bayzdelivery.dto.Top3DeliveryMenResponse;
import com.bayzdelivery.dto.PersonRequest;
import com.bayzdelivery.model.Person;

public interface PersonService {
  public List<Person> getAll();

  public Person save(PersonRequest p);

  public Person findById(Long personId);
  public List<Top3DeliveryMenResponse> getTop3DeliveryMen(Instant startDate, Instant endDate);
}
