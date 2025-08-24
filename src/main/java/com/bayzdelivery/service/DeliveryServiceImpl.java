package com.bayzdelivery.service;

import java.util.Optional;

import com.bayzdelivery.dto.DeliveryRequest;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.model.StatusEnum;
import com.bayzdelivery.model.TypeEnum;
import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.model.Delivery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final PersonService personService;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, PersonService personService) {
        this.deliveryRepository = deliveryRepository;
        this.personService = personService;
    }

    public Delivery save(DeliveryRequest request) {
      Person deliveryMan = personService.findById(request.getDeliveryManId());
      Person customer = personService.findById(request.getCustomerId());
      if (deliveryMan.getType() != TypeEnum.DELIVERY_MAN || customer.getType() != TypeEnum.CUSTOMER) {
          return null;
      }
      if (deliveryMan.getStatus()== StatusEnum.BUSY){
          return null;
      }
      Delivery delivery = new Delivery();
      delivery.setDistance(request.getDistance());
      delivery.setStartTime(request.getStartTime());
      delivery.setEndTime(request.getEndTime());
      delivery.setPrice(request.getPrice());
      delivery.setDeliveryMan(deliveryMan);
      delivery.setCustomer(customer);

      double commission = calculateCommission(request);
      delivery.setComission(commission);
      return deliveryRepository.save(delivery);
  }

  public Delivery findById(Long deliveryId) {
    Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
    if (optionalDelivery.isPresent()) {
      return optionalDelivery.get();
    }else return null;
  }

  public double calculateCommission(DeliveryRequest delivery){
      return  delivery.getPrice()*0.05 + delivery.getDistance()*0.5;
  }
}
