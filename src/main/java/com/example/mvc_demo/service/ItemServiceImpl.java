package com.example.mvc_demo.service;

import com.example.mvc_demo.domain.Item;
import com.example.mvc_demo.domain.ItemAddForm;
import com.example.mvc_demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }
    @Override
    public void deleteItemById(long id) {
        itemRepository.delete(id);
    }

    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10);
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
            System.out.println(itemRepository.findById(item.getId()));
        }
    }
}
