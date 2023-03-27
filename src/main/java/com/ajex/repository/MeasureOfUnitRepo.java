package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.MeasureOfUnit;

public interface MeasureOfUnitRepo extends MongoRepository<MeasureOfUnit, Integer> {
	

}
