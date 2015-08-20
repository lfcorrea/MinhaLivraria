package com.lf.minhalivraria.model.buscape;

import java.util.Arrays;

public class Item {
    private String[] value;

    private String label;

    public Item() {
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + Arrays.toString(value) +
                ", label='" + label + '\'' +
                '}';
    }
}
