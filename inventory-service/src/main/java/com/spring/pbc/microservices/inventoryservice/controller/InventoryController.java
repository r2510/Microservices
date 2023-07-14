package com.spring.pbc.microservices.inventoryservice.controller;

import com.spring.pbc.microservices.inventoryservice.dto.InventoryResponse;
import com.spring.pbc.microservices.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //api/inventory/iphone-13
    //api/inventory/iphone-13,iphone-13-red
    //RequestParam - api/inventory/skuCode:iphone-13&skuCode:iphone-13-red


    //    @GetMapping("/{sku-code}")
    //    @ResponseStatus(HttpStatus.OK)
    //    public boolean isInStock(@PathVariable("sku-code") String skuCode){
    //        return inventoryService.isInStock(skuCode);
//    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam("skuCode") List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
