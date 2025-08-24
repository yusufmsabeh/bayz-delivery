package com.bayzdelivery.service;

import com.bayzdelivery.dto.DeliveryRequest;
import com.bayzdelivery.model.Delivery;

public interface DeliveryService {

  public Delivery save(DeliveryRequest delivery);

  public Delivery findById(Long deliveryId);
}
