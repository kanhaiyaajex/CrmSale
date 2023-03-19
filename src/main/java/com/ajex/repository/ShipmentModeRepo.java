package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.ShipmentMode;

public interface ShipmentModeRepo extends MongoRepository<ShipmentMode, String> {

}
