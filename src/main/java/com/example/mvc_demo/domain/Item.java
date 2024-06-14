package com.example.mvc_demo.domain;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "code", nullable = false, updatable = false, unique = true)
    private String inventoryCode;

    public Item() {
    }

    public Item(String inventoryCode, String type) {
        this.inventoryCode = inventoryCode;
        this.type = type;
    }

    @Column(name = "type", nullable = false)
    private String type;

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", inventoryCode='" + inventoryCode + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
}
