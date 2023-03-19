package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.Region;

public interface RegionRepo extends MongoRepository<Region, String> {

}
