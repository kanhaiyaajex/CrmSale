package com.ajex.service;

import java.util.List;

import com.ajex.dto.RateCardDto;
import com.ajex.entity.RateCard;

public interface RateCardService {
	
	public RateCardDto addRateCard(RateCard RateCard);
	
	public RateCardDto updateRateCard(String id,RateCard RateCard);

	
	public void deleteRateCard(String id);
	
	
	public List<RateCard> getAllRateCard();

     	

	


}
