package com.lf.minhalivraria.model.buscape;

public class Eonandyear {
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