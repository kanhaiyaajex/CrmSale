package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.Position;

public interface PositionRepo extends MongoRepository<Position, Integer> {

}
