package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Eonandyear implements Serializable {
    private long lowestsetbit;

    public Eonandyear() {
    }

    public long getLowestsetbit() {
        return lowestsetbit;
    }

    public void setLowestsetbit(long lowestsetbit) {
        this.lowestsetbit = lowestsetbit;
    }

    @Override
    public String toString() {
        return "Eonandyear{" +
                "lowestsetbit='" + lowestsetbit + '\'' +
                '}';
    }
}