package com.ajex.service;

import java.util.List;

import com.ajex.dto.RegionDto;
import com.ajex.entity.Region;
import com.ajex.exception.ResourceNotFoundException;

public interface RegionService {
	
	public RegionDto addRegion(Region Region) throws ResourceNotFoundException;
	
	public RegionDto updateRegion(Region region) throws ResourceNotFoundException;

	
	public void deleteRegion(Integer id);
	
	
	public List<Region> getAllRegion();

     	

	


}
