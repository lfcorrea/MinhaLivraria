package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Currency implements Serializable {
    private String abbreviation;

    public Currency() {
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
