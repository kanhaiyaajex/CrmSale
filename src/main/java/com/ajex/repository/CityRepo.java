package com.ajex.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ajex.entity.City;
import com.ajex.entity.Region;

public interface CityRepo  extends MongoRepository<City, Integer>{
	
	
@Query(value="select * from City where regionId=:regionId")
	
	List<City> allCityInRegion(@Param("regionId") Integer regionId);

}
