package com.example.mvc_demo.repository;

import com.example.mvc_demo.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findByInventoryCode(String inventoryCode);

}
