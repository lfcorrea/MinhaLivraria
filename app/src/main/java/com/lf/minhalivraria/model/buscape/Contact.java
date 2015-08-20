package com.lf.minhalivraria.model.buscape;

public class Contact {
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
