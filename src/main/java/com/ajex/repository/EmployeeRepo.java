package com.ajex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajex.entity.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

}
