package com.ajex.service.impl;

import static com.ajex.entity.RateCard.SEQUENCE_NAME;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajex.dto.RateCardDto;
import com.ajex.entity.Product;
import com.ajex.entity.RateCard;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.repository.ProductRepo;
import com.ajex.repository.RateCardRepo;
import com.ajex.service.RateCardService;



@Service
public class RateCardServiceImpl implements RateCardService {



@Autowired
private com.ajex.entity.SequenceGeneratorService service;



@Autowired
private RateCardRepo  RateCardRepo;



@Autowired
private ProductRepo  productRepo;

	@Override
	public RateCardDto addRateCard(RateCard rateCard) throws ResourceNotFoundException {
  
		Product productValue= productRepo.findById(rateCard.getProductId().getProductId()).get();
if(productValue==null)
{
	
	throw new ResourceNotFoundException("Product does not exist");
}
        rateCard.setProductId(productValue);
		rateCard.setRateCardId(service.getSequenceNumber(SEQUENCE_NAME));
		RateCard RateCardValue=RateCardRepo.save(rateCard);
		RateCardDto RateCardDto = new ModelMapper().map(RateCardValue, RateCardDto.class);

		return RateCardDto;
	}

	@Override
	public RateCardDto updateRateCard(Integer id,RateCard rateCard) {

		RateCardDto RateCardDto=null;
		Optional<RateCard> RateCardData = RateCardRepo.findById(id);

		  if (RateCardData.isPresent()) {
			  RateCardData.get().setRateCardId(id);

		    
		    RateCardRepo.save(RateCardData.get());
			RateCardDto = new ModelMapper().map(RateCardRepo.save(RateCardData.get()), RateCardDto.class);

		  }
		  return RateCardDto;	}



	@Override
	public void deleteRateCard(Integer id) {

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
