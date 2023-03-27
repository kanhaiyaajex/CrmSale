package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.PortCities;

public interface PortCitiesRepo extends MongoRepository<PortCities, Integer> {

}
