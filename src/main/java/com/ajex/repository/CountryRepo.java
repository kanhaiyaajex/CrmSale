package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.Country;

public interface CountryRepo extends MongoRepository<Country, Integer> {

}
