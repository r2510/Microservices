package com.spring.pbc.microservices.productservice.service;

import com.spring.pbc.microservices.productservice.dto.ProductRequest;
import com.spring.pbc.microservices.productservice.dto.ProductResponse;
import com.spring.pbc.microservices.productservice.model.Product;
import com.spring.pbc.microservices.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        //productRequest ko Product me convert karna padega
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProduct() {
        //dB contians all product but we need to convert it into ProductResponse
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> mapProductToProductResponse(product)).toList();

    }

    private ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
