package com.lf.minhalivraria.model;

/**
 * Created by luizfernando on 7/13/15.
 */
public class Book {
    private String kind;
    private int totalItems;
    private Item[] items;

    public Book() {
    }

    public Book(String kind, int totalItems, Item[] items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}

