package com.example.mvc_demo.service;

import com.example.mvc_demo.domain.Item;
import com.example.mvc_demo.domain.ItemAddForm;
import com.example.mvc_demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ItemService {
    Iterable<Item> getItems();
    void deleteItemById(long id);
    void addItem(ItemAddForm form);

    Item getItemById(long id);
    Item assignItem(String username, long itemId);

}

