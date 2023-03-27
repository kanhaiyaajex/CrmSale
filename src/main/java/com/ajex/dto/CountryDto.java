package com.ajex.dto;

import java.util.List;

import com.ajex.entity.Region;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

	private Integer countryId;

	private String countryCode;

	private List<Region> region;

	private String countryName;

	private Integer refId;

	private boolean statusId;

}
