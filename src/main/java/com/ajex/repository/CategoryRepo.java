package com.ajex.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.Category;

public interface CategoryRepo extends MongoRepository<Category, Integer> {

	

}
