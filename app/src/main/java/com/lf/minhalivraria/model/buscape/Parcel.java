package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Parcel implements Serializable {
    private int interest;

    private double value;

    private int number;

    public Parcel() {
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "interest='" + interest + '\'' +
                ", value='" + value + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
