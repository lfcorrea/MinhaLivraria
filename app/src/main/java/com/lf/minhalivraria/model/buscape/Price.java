package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Price implements Serializable {
    private Parcel parcel;

    private double value;

    private Currency currency;

    public Price() {
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price{" +
                "parcel=" + parcel +
                ", value='" + value + '\'' +
                ", currency=" + currency +
                '}';
    }
}
