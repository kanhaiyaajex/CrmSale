package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.CityGroup;

public interface CityGroupRepo  extends MongoRepository<CityGroup, String> {

}
