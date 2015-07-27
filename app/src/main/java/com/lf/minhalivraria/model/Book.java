package com.lf.minhalivraria.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

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

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        String _kind = jsonObject.getString("kind");
        setKind(_kind);

        int _totalItems = jsonObject.getInt("totalItems");
        setTotalItems(_totalItems);

        if (_totalItems > 0 && jsonObject.has("items")) {
            JSONArray _itemsObject = jsonObject.getJSONArray("items");
            Item[] _items = new Item[_totalItems];
            for (int i = 0; i < _totalItems; i++) {
                Item item = new Item();
                item.loadFromJSON(_itemsObject.getJSONObject(i));
                _items[i] = item;
            }

            setItems(_items);
        }

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

    public boolean hasItems() {
        return totalItems > 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "kind='" + kind + '\'' +
                ", totalItems=" + totalItems +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}

