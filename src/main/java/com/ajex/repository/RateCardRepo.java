package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.RateCard;

public interface RateCardRepo extends MongoRepository<RateCard, Integer> {

}
