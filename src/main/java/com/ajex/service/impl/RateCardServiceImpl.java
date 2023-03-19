package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.RateCardDto;
import com.ajex.entity.RateCard;
import com.ajex.repository.RateCardRepo;
import com.ajex.service.RateCardService;



@Service
public class RateCardServiceImpl implements RateCardService {



@Autowired
private RateCardRepo  RateCardRepo;


	@Override
	public RateCardDto addRateCard(RateCard RateCard) {
  
		
		RateCard RateCardValue=RateCardRepo.save(RateCard);
		RateCardDto RateCardDto = new ModelMapper().map(RateCardValue, RateCardDto.class);

		return RateCardDto;
	}

	@Override
	public RateCardDto updateRateCard(String id,RateCard RateCard) {

		RateCardDto RateCardDto=null;
		Optional<RateCard> RateCardData = RateCardRepo.findById(id);

		  if (RateCardData.isPresent()) {
		    RateCard RateCardVal = new RateCard();
		    RateCardVal.setRateCardId(id);
//		    RateCardVal.setRateCardNameInAr(RateCard.getRateCardNameInAr());
//		    RateCardVal.setRateCardCode(RateCard.getRateCardCode());
//		    RateCardVal.setCountryId(RateCard.getCountryId());
//		    RateCardVal.setRegionId(RateCard.getRegionId());
//		    RateCardVal.setStatusId(RateCard.isStatusId());
		    
		    RateCardRepo.save(RateCard);
			RateCardDto = new ModelMapper().map(RateCardRepo.save(RateCard), RateCardDto.class);

		  }
		  return RateCardDto;	}



	@Override
	public void deleteRateCard(String id) {

		RateCard RateCardValue= RateCardRepo.findById(id).get();
		
		if(RateCardValue!=null)
		{
			RateCardRepo.delete(RateCardValue);
			
		}
	}

	@Override
	public List<RateCard> getAllRateCard() {
		
      List<RateCard> RateCardValue= RateCardRepo.findAll();

		
		if(!RateCardValue.isEmpty())
				
		{
			return RateCardValue;
		}
		return RateCardValue;
	}

}
