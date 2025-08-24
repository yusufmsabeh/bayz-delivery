package com.bayzdelivery.repositories;

import com.bayzdelivery.dto.NotDeliveredOrders;
import com.bayzdelivery.model.Delivery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource(exported = false)
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    /*
    * Custom Repository Function which is responsible for getting ongoing orders ( Incomplete )
    * This query returns the id and the start time for a delivery with endTime null ( not delivered yet )
    * I could put the logic for getting the incomplete orders that is overdue by 45 minutes but I shift the logic from the database server to
    * the application server and also for better readability and maintainability
    * */
    @Query("SELECT NEW com.bayzdelivery.dto.NotDeliveredOrders(" +
            "d.id ," +
            "d.startTime" +
            ") " +
            "FROM Delivery d " +
            "WHERE d.endTime IS NULL")
    List<NotDeliveredOrders> findByNullEndTime();
}
