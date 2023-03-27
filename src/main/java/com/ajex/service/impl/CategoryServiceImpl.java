package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ajex.entity.Category.*;


import com.ajex.dto.CityDto;
import com.ajex.dto.CategoryDto;
import com.ajex.entity.City;
import com.ajex.entity.CityGroup;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.service.CategoryService;
import com.ajex.entity.Category;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private com.ajex.entity.SequenceGeneratorService service;

	@Autowired
	private com.ajex.repository.CategoryRepo CategoryRepo;

	@Override
	public CategoryDto addCategory(Category Category) {

		Category.setCategoryId(service.getSequenceNumber(SEQUENCE_NAME));
		Category CategoryValue = CategoryRepo.save(Category);
		CategoryDto CategoryDto = new ModelMapper().map(CategoryValue, CategoryDto.class);

		return CategoryDto;
	}

	@Override
	public ResponseEntity<?> updateCategory(Integer id, Category Category) throws ResourceNotFoundException  {


		Category CategoryVal = CategoryRepo.findById(id)

				.orElseThrow(() -> new ResourceNotFoundException("Category not found on :: " + id));

		CategoryVal.setCategoryId(id);
		CategoryVal.setName(Category.getName());
		CategoryVal.setStatusId(Category.isStatusId());

		CategoryDto CategoryDto = new ModelMapper().map(CategoryRepo.save(CategoryVal), CategoryDto.class);
		return new ResponseEntity<>(CategoryDto, HttpStatus.OK);

	}

	@Override
	public void deleteCategory(Integer id) {

		Category CategoryValue = CategoryRepo.findById(id).get();

		if (CategoryValue != null) {
			CategoryRepo.delete(CategoryValue);

		}
	}

	@Override
	public List<Category> getAllCategories() {
		
		List<Category> CategoryValue = CategoryRepo.findAll();
		
		
		
		return CategoryValue;
	}


}
