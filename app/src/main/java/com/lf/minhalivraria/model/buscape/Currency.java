package com.lf.minhalivraria.model.buscape;

public class Currency {
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
