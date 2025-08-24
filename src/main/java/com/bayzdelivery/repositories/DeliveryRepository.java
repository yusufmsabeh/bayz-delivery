package com.bayzdelivery.repositories;

import com.bayzdelivery.dto.NotDeliveredOrders;
import com.bayzdelivery.model.Delivery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource(exported = false)
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    @Query("SELECT NEW com.bayzdelivery.dto.NotDeliveredOrders(" +
            "d.id ," +
            "d.startTime" +
            ") " +
            "FROM Delivery d " +
            "WHERE d.endTime IS NULL")
    List<NotDeliveredOrders> findByNullEndTime();
}
