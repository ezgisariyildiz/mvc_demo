package com.example.mvc_demo.service;

import com.example.mvc_demo.domain.Item;
import com.example.mvc_demo.domain.ItemAddForm;
import com.example.mvc_demo.domain.User;
import com.example.mvc_demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    @Override
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10);
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
            System.out.println(itemRepository.findById(item.getId()));
        }
    }
    public Item getItemById(long id) {
        itemRepository.findById(id);
        return null;
    }
    public Item assignItem(String username, long itemId) {
        User user = userService.getUserByUsername(username);
        Item item = getItemById(itemId);
        Set<Item> itemList = user.getItems();
        itemList.add(item);
        user.setItems(itemList);
        item.setUser(user);
        return itemRepository.save(item);
    }

    public void deleteItemById(long id) {
        itemRepository.deleteById(id);
    }
}
