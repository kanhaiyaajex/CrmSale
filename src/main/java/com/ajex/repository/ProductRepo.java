package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.Product;

public interface ProductRepo extends MongoRepository<Product, Integer> {

}
