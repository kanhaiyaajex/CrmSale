package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.Division;

public interface DivisionRepo extends MongoRepository<Division, Integer> {

}
