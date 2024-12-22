package com.example.inventoryapp;

public class InventoryItem {
    private int id;
    private String name;
    private String category;
    private int stockLevel;

    // Constructor
    public InventoryItem(int id, String name, String category, int stockLevel) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stockLevel = stockLevel;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getStockLevel() {
        return stockLevel;
    }
}