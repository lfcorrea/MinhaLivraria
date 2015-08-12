package com.lf.minhalivraria.model.buscape.offer.seller;

import com.lf.minhalivraria.model.buscape.JSONObjectConverter;
import com.lf.minhalivraria.model.buscape.Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class EbitRating implements JSONObjectConverter {

    private long ratingId;
    private String rating;
    private String ratingNew;
    private long numberOfComments;

    public EbitRating() {
    }

    public EbitRating(long ratingId, String rating, String ratingNew, long numberOfComments) {
        this.ratingId = ratingId;
        this.rating = rating;
        this.ratingNew = ratingNew;
        this.numberOfComments = numberOfComments;
    }

    public EbitRating(JSONObject jsonObject) {
    }

    @Override
    public void toJSON() {
        //@TODO
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        long _ratingId = Util.getLong(jsonObject, "ratingid");
        setRatingId(_ratingId);

        String _rating = Util.getString(jsonObject, "rating");
        setRating(_rating);

        String _ratingNew = Util.getString(jsonObject, "ratingnew");
        setRatingNew(_ratingNew);

        long _numberOfComments = Util.getLong(jsonObject, "numcomments");
        setNumberOfComments(_numberOfComments);

    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    public long getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(long numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getRatingNew() {
        return ratingNew;
    }

    public void setRatingNew(String ratingNew) {
        this.ratingNew = ratingNew;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EbitRating)) return false;

        EbitRating that = (EbitRating) o;

        if (getRatingId() != that.getRatingId()) return false;
        if (getNumberOfComments() != that.getNumberOfComments()) return false;
        if (getRating() != null ? !getRating().equals(that.getRating()) : that.getRating() != null)
            return false;
        return !(getRatingNew() != null ? !getRatingNew().equals(that.getRatingNew()) : that.getRatingNew() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getRatingId() ^ (getRatingId() >>> 32));
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (getRatingNew() != null ? getRatingNew().hashCode() : 0);
        result = 31 * result + (int) (getNumberOfComments() ^ (getNumberOfComments() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "EbitRating{" +
                "ratingId=" + ratingId +
                ", rating='" + rating + '\'' +
                ", ratingNew='" + ratingNew + '\'' +
                ", numberOfComments=" + numberOfComments +
                '}';
    }

}
