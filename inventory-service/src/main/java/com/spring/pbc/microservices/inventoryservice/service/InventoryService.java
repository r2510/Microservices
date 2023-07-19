package com.spring.pbc.microservices.inventoryservice.service;

import com.spring.pbc.microservices.inventoryservice.dto.InventoryResponse;
import com.spring.pbc.microservices.inventoryservice.model.Inventory;
import com.spring.pbc.microservices.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows//not recomended
    public List<InventoryResponse> isInStock(List<String> skuCode){
        log.info("Waait Started");
        Thread.sleep(10000);
        log.info("Wait ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder().skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                )
                .toList();
    }
}
