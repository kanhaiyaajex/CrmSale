package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.AdditionalService;

public interface AdditionalServiceRepo extends MongoRepository<AdditionalService, Integer> {

}
