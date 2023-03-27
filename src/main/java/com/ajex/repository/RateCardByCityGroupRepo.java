package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.RateCardByCityGroup;

public interface RateCardByCityGroupRepo extends MongoRepository<RateCardByCityGroup, Integer> {

}
