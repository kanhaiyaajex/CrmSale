package com.ajex.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajex.dto.CountryRegionCityDto;
import com.ajex.dto.RegionFx;
import com.ajex.entity.AdditionalService;
import com.ajex.entity.City;
import com.ajex.entity.CityGroup;
import com.ajex.entity.Country;
import com.ajex.entity.Division;
import com.ajex.entity.MeasureOfUnit;
import com.ajex.entity.Position;
import com.ajex.entity.Region;
import com.ajex.repository.CityRepo;
import com.ajex.repository.RegionRepo;
import com.ajex.service.AdditionalServices;
import com.ajex.service.CityGroupService;
import com.ajex.service.CityService;
import com.ajex.service.CountryService;
import com.ajex.service.DivisionService;
import com.ajex.service.MeasureOfUnitService;
import com.ajex.service.PositionService;
import com.ajex.service.RegionService;

@RestController

@RequestMapping("/api/v1/applicationDefault/")
public class ApplicationDefaultController {
	
	@Autowired
	private CityGroupService  CityGroupService;
	

	@Autowired
	private CountryService  countryService;
	

	@Autowired
	private CityService  cityService;
	

	@Autowired
	private RegionService  regionService;
	

	@Autowired
	private RegionRepo  regionRepo;
	
	@Autowired
	private CityRepo  cityRepo;
	
	

	@Autowired
	private PositionService  PositionService;
	@Autowired
	private DivisionService  DivisionService;


	@Autowired
	private MeasureOfUnitService  MeasureOfUnitService;
	
	@Autowired
	private AdditionalServices  AdditionalServiceService;

	@GetMapping("/cityPositionDivUnitAService")
	public  ResponseEntity<?>  getAllCity()
	{
		
		
		try {
			
			
					
			List<CityGroup>  allCityGroup= CityGroupService.getAllCityGroup();
			List<Division>  allDivs= DivisionService.getAllDivision();
			List<Position>  allPositions= PositionService.getAllPosition();
			List<MeasureOfUnit>  allUnits= MeasureOfUnitService.getAllMeasureOfUnit();
			List<AdditionalService>  allAddlServices= AdditionalServiceService.getAllAdditionalService();
			
			
			CityGroup cgl= null;
			Division  dvl= new Division();
			Position psl= new Position();
			MeasureOfUnit mul= new MeasureOfUnit();
			AdditionalService addlServices= new AdditionalService();
			
			
			List<CityGroup>  allCityGroupList= new ArrayList<CityGroup>();
			List<Division>  allDivsList= new ArrayList<Division>();
			List<Position>  allPositionsList= new ArrayList<Position>();
			List<MeasureOfUnit>  allUnitsList= new ArrayList<MeasureOfUnit>();
			List<AdditionalService>  allAddlServicesList= new ArrayList<AdditionalService>();

			
			
			Map<Object,Object> m1= new HashMap<>();
			

			for (CityGroup cg : allCityGroup) {
				cgl= new CityGroup();

				cgl.setCityGroupId(cg.getCityGroupId());
				cgl.setGroupName(cg.getGroupName());
				cgl.setGroupOrderId(cg.getGroupOrderId());
				cgl.setStatusId(cg.isStatusId());
				
				allCityGroupList.add(cgl);
				
				
			


			}

			for (Division div : allDivs) {
				dvl.setDivisionId(div.getDivisionId());
				dvl.setDivisionName(div.getDivisionName());

				dvl.setStatusId(div.isStatusId());
				allDivsList.add(dvl);
			
			}

			for (Position pos : allPositions) {
				psl.setPositionId(pos.getPositionId());
				psl.setPositionName(pos.getPositionName());
				psl.setOrderId(pos.getOrderId());

				psl.setStatusId(pos.isStatusId());
				allPositionsList.add(psl);
			

			}

			for (MeasureOfUnit un : allUnits) {
				mul.setMeasureOfUnitId(un.getMeasureOfUnitId());
				mul.setUnitName(un.getUnitName());
				mul.setStatusId(un.isStatusId());
				allUnitsList.add(mul);
				
			}
			for (AdditionalService als : allAddlServices) {
				addlServices.setAdditionalServiceId(als.getAdditionalServiceId());
				addlServices.setCategoryId(als.getCategoryId());
				addlServices.setDivisionId(als.getDivisionId());
				addlServices.setStatusId(als.isStatusId());
				allAddlServicesList.add(addlServices);
				
			}	
	
			

			
			        m1.put("cityGroup",  	allCityGroupList);
			
					m1.put("divisions", allDivsList);
					m1.put("units", allUnitsList);

					m1.put("positions", allPositionsList);
					m1.put("addlServices", allAddlServicesList);

					Map <Object,Object> m= new HashMap<>();
					m.put("success", true);
					m.put("statusCode", HttpStatus.OK);
					m.put("status", 200);

					m.put("data", m1);
					
			
					
					
			return new ResponseEntity<>(m, HttpStatus.OK);
			
		}catch (Exception e) {
			
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@ResponseBody
	@GetMapping("/regionCityCountry")
	public  CountryRegionCityDto   getRegionCityCountry()
	{
		
		
		
			Map<Object,Object> m = new  HashMap<>();

			List<Country> allCountry= countryService.getAllCountries();
			List<Region> allRegion= regionService.getAllRegion();
			List<City> allCity= cityService.getAllCity();
			
			List<City> allCityInReg =null;
			Country  country= null;
			List<Country> allC= new ArrayList<>();
			List<Region> allReg= new ArrayList<>();

			Region region =null;
			City  city= null;
	
		    RegionFx rr=null;
			CountryRegionCityDto crc= null;
			List<CountryRegionCityDto> crcList= new ArrayList<>();
			List<RegionFx> rrlist= new ArrayList<>();

			JSONObject jsonComplex = new JSONObject();
		    JSONObject notification = new JSONObject();
		    JSONObject targetJsonObject= new JSONObject();
		    JSONArray targetJsonArray= new JSONArray();
		    JSONObject appsJsonObject= new JSONObject();
		    Integer countryId=null;
		    Region[] regionNames=null;
			for(Country cl:allCountry)
			
				
			{
				
				
                countryId=cl.getCountryId();
				crc= new CountryRegionCityDto();
				crc.setCountryId(cl.getCountryId());
				crc.setCountryName(cl.getCountryName());
				List<Region> allRegInCount= regionRepo.allRegionInCountry(countryId);
			
				 System.out.println(cl.getCountryId());
			    String regs =allRegInCount.stream()
			    	      .map(Region::getRegionName)
			    	      .collect(Collectors.joining(", "))
			    	      .toString();
			    Region r= new Region();
			    r.setRegionName(regs);
			    System.out.println(regs);
			     regionNames = new Region[] {r};

			    System.out.println("regs"+regs);

			}
		    crc.setRegion(regionNames);


			//crcList.add(crc);

				//crcList.add(crc);
			
			

return crc;
	}
}
		
	
		

	
	


	
