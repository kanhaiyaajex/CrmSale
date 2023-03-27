package com.ajex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ajex.dto.CityDto;
import com.ajex.dto.MeasureOfUnitDto;
import com.ajex.entity.City;
import com.ajex.entity.MeasureOfUnit;

public interface MeasureOfUnitService {
	
	public MeasureOfUnitDto addMeasureOfUnit(MeasureOfUnit MeasureOfUnit);
	
	public ResponseEntity<?> updateMeasureOfUnit(Integer id,MeasureOfUnit MeasureOfUnit) ;

	
	public void deleteMeasureOfUnit(Integer id);
	
	
	public List<MeasureOfUnit> getAllMeasureOfUnit();


     	

	


}
