package com.ajex.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ajex.entity.Region;

public interface RegionRepo extends MongoRepository<Region, Integer> {
	
	
	
	
	@Query(value="select * from Region where countryId=:countryId")
	
	List<Region> allRegionInCountry(@Param("countryId") Integer countryId);

}
