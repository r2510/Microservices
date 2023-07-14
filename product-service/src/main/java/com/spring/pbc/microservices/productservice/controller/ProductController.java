package com.spring.pbc.microservices.productservice.controller;

import com.spring.pbc.microservices.productservice.dto.ProductRequest;
import com.spring.pbc.microservices.productservice.dto.ProductResponse;
import com.spring.pbc.microservices.productservice.repository.ProductRepository;
import com.spring.pbc.microservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creatrProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }
}
