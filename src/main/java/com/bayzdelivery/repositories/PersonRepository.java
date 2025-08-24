package com.bayzdelivery.repositories;

import com.bayzdelivery.dto.Top3DeliveryMenResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import com.bayzdelivery.model.Person;

import java.time.Instant;
import java.util.List;

@RestResource(exported=false)
public interface PersonRepository extends CrudRepository<Person, Long>, PagingAndSortingRepository<Person, Long> {

    @Query("SELECT NEW com.bayzdelivery.dto.Top3DeliveryMenResponse(\n" +
        "    p.id, \n" +
        "    p.name, \n" +
        "    p.email, \n" +
        "    p.registrationNumber, \n" +
        "    SUM(d.comission), \n" +
        "    AVG(d.comission)\n" +
        ")\n" +
        "FROM Person p \n" +
        "JOIN Delivery d ON p.id = d.deliveryMan.id \n" +
        "WHERE p.type = com.bayzdelivery.model.TypeEnum.DELIVERY_MAN AND d.endTime BETWEEN :startDate AND :endDate \n" +
        "GROUP BY p.id, p.name, p.email, p.registrationNumber\n" +
        "ORDER BY SUM(d.comission) DESC " + "LIMIT 3")
    List<Top3DeliveryMenResponse> getTop3DeliveryMenCommission(@Param("startDate") Instant startDate , @Param("endDate") Instant endDate);
}
