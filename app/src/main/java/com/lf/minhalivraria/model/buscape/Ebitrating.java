package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Ebitrating implements Serializable {
    private String rating;

    private long ratingid;

    private long numcomments;

    private String ratingnew;

    public Ebitrating() {
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public long getRatingid() {
        return ratingid;
    }

    public void setRatingid(long ratingid) {
        this.ratingid = ratingid;
    }

    public long getNumcomments() {
        return numcomments;
    }

    public void setNumcomments(long numcomments) {
        this.numcomments = numcomments;
    }

    public String getRatingnew() {
        return ratingnew;
    }

    public void setRatingnew(String ratingnew) {
        this.ratingnew = ratingnew;
    }

    @Override
    public String toString() {
        return "Ebitrating{" +
                "rating='" + rating + '\'' +
                ", ratingid='" + ratingid + '\'' +
                ", numcomments='" + numcomments + '\'' +
                ", ratingnew='" + ratingnew + '\'' +
                '}';
    }
}
