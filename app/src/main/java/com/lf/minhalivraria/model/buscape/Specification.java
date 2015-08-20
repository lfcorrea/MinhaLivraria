package com.lf.minhalivraria.model.buscape;

import java.util.Arrays;

public class Specification {
    private Item[] item;

    private Links[] links;

    public Specification() {
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public Links[] getLinks() {
        return links;
    }

    public void setLinks(Links[] links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "item=" + Arrays.toString(item) +
                ", links=" + Arrays.toString(links) +
                '}';
    }
}
