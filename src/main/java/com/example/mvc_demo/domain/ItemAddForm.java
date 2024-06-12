package com.example.mvc_demo.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ItemAddForm {
    @NotEmpty
    @Size(min = 2, max = 50)
    private String itemType;

    @NotNull
    private int amount = 1; //default

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
