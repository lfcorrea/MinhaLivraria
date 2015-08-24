package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Rating implements Serializable {
    private Ebitrating ebitrating;

    private Useraveragerating useraveragerating;

    public Rating() {
    }

    public Ebitrating getEbitrating() {
        return ebitrating;
    }

    public void setEbitrating(Ebitrating ebitrating) {
        this.ebitrating = ebitrating;
    }

    public Useraveragerating getUseraveragerating() {
        return useraveragerating;
    }

    public void setUseraveragerating(Useraveragerating useraveragerating) {
        this.useraveragerating = useraveragerating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ebitrating=" + ebitrating +
                ", useraveragerating=" + useraveragerating +
                '}';
    }
}
