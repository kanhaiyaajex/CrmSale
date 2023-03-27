package com.ajex.service;

import java.util.List;

import com.ajex.dto.RateCardDto;
import com.ajex.entity.RateCard;
import com.ajex.exception.ResourceNotFoundException;

public interface RateCardService {
	
	public RateCardDto addRateCard(RateCard RateCard) throws ResourceNotFoundException;
	
	public RateCardDto updateRateCard(Integer id,RateCard RateCard);

	
	public void deleteRateCard(Integer id);
	
	
	public List<RateCard> getAllRateCard();

     	

	


}
