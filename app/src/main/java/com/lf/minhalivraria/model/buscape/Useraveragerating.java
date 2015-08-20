package com.lf.minhalivraria.model.buscape;

import java.util.Arrays;

public class Useraveragerating {
    private Links[] links;

    private String rating;

    private int numcomments;

    public Useraveragerating() {
    }

    public Links[] getLinks() {
        return links;
    }

    public void setLinks(Links[] links) {
        this.links = links;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNumcomments() {
        return numcomments;
    }

    public void setNumcomments(int numcomments) {
        this.numcomments = numcomments;
    }

    @Override
    public String toString() {
        return "Useraveragerating{" +
                "links=" + Arrays.toString(links) +
                ", rating='" + rating + '\'' +
                ", numcomments='" + numcomments + '\'' +
                '}';
    }
}
