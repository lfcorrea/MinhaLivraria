package com.lf.minhalivraria.model.buscape_old.offer.seller;

import com.lf.minhalivraria.model.buscape_old.JSONObjectConverter;
import com.lf.minhalivraria.model.buscape_old.Link;
import com.lf.minhalivraria.model.buscape_old.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class UserAverageRating implements JSONObjectConverter {

    private String rating;
    private long numberOfComments;

    private Link[] links;

    public UserAverageRating() {
    }

    public UserAverageRating(String rating, long numberOfComments, Link[] links) {
        this.rating = rating;
        this.numberOfComments = numberOfComments;
        this.links = links;
    }

    public UserAverageRating(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {
        //@TODO
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        String _rating =  Util.getString(jsonObject, "rating");
        setRating(_rating);

        long _numberOfComments =  Util.getLong(jsonObject, "numcomments");
        setNumberOfComments(_numberOfComments);

        setLinks(Util.getLinks(jsonObject));

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public long getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(long numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAverageRating)) return false;

        UserAverageRating that = (UserAverageRating) o;

        if (getNumberOfComments() != that.getNumberOfComments()) return false;
        if (getRating() != null ? !getRating().equals(that.getRating()) : that.getRating() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getLinks(), that.getLinks());

    }

    @Override
    public int hashCode() {
        int result = getRating() != null ? getRating().hashCode() : 0;
        result = 31 * result + (int) (getNumberOfComments() ^ (getNumberOfComments() >>> 32));
        result = 31 * result + (getLinks() != null ? Arrays.hashCode(getLinks()) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserAverageRating{" +
                "rating='" + rating + '\'' +
                ", numberOfComments=" + numberOfComments +
                ", links=" + Arrays.toString(links) +
                '}';
    }
}
