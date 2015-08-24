package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Contact implements Serializable {
    private String value;

    private String label;

    public Contact() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
        return "Contact{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
