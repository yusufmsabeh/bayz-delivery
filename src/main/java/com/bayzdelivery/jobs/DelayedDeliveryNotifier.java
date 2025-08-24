package com.bayzdelivery.jobs;

import com.bayzdelivery.dto.NotDeliveredOrders;
import com.bayzdelivery.repositories.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Component
public class DelayedDeliveryNotifier {

    private static final Logger LOG = LoggerFactory.getLogger(DelayedDeliveryNotifier.class);
    private final DeliveryRepository deliveryRepository;

    @Autowired
    DelayedDeliveryNotifier(DeliveryRepository deliveryRepository){
        this.deliveryRepository=deliveryRepository;
    }
    /**
     *  Use this method for the TASK 3
     */
    @Scheduled(fixedDelay = 180000)
    public void checkDelayedDeliveries() {
        List<NotDeliveredOrders> notDeliveredOrders= deliveryRepository.findByNullEndTime();
        Instant cutOffTime = Instant.now().minus(Duration.ofMinutes(45));
        for(NotDeliveredOrders notDeliveredOrder: notDeliveredOrders){
            if (notDeliveredOrder.getStartTime().isBefore(cutOffTime)){
                notifyCustomerSupport(notDeliveredOrder.getId());
            }
        }




    }


    /**
     * This method should be called to notify customer support team
     * It just writes notification on console but it may be email or push notification in real.
     * So that this method should run in an async way.
     */
    @Async
    public void notifyCustomerSupport(Long id) {
        LOG.info("Customer support team is notified! this Delivery is delayed "+id);
    }
}
