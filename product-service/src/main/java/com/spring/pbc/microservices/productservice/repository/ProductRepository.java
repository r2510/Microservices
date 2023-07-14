package com.spring.pbc.microservices.productservice.repository;

import com.spring.pbc.microservices.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
