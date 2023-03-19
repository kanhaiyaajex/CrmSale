package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.City;

public interface CityRepo  extends MongoRepository<City, String>{

}
