package com.ajex.service;

import java.util.List;

import com.ajex.dto.RegionDto;
import com.ajex.entity.Region;

public interface RegionService {
	
	public RegionDto addRegion(Region Region);
	
	public RegionDto updateRegion(String id,Region Region);

	
	public void deleteRegion(String id);
	
	
	public List<Region> getAllRegion();

     	

	


}
