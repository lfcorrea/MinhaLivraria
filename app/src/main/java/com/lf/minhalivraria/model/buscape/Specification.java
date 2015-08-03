package com.lf.minhalivraria.model.buscape;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Specification implements JSONObjectConverter {

    private Item[] items;
    private Link[] links;

    public Specification() {
    }

    public Specification(Item[] items, Link[] links) {
        this.items = items;
        this.links = links;
    }

    public Specification(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        JSONArray _itemsArray = jsonObject.getJSONArray("Item");
        int sizeItems = _itemsArray.length();
        Item [] _items = new Item[sizeItems];
        for(int i = 0; i<sizeItems; i++){
            Item _item = new Item(_itemsArray.getJSONObject(i));
            _items[i] = _item;
        }
        setItems(_items);

        setLinks(getLinks(jsonObject));

    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specification)) return false;

        Specification that = (Specification) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getItems(), that.getItems())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getLinks(), that.getLinks());

    }

    @Override
    public int hashCode() {
        int result = getItems() != null ? Arrays.hashCode(getItems()) : 0;
        result = 31 * result + (getLinks() != null ? Arrays.hashCode(getLinks()) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "items=" + Arrays.toString(items) +
                ", links=" + Arrays.toString(links) +
                '}';
    }
}
