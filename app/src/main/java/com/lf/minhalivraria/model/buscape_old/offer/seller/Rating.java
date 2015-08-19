package com.lf.minhalivraria.model.buscape_old.offer.seller;

import com.lf.minhalivraria.model.buscape_old.JSONObjectConverter;
import com.lf.minhalivraria.model.buscape_old.Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Rating implements JSONObjectConverter {

    private EbitRating ebitRating;
    private UserAverageRating userAverageRating;

    public Rating() {
    }

    public Rating(EbitRating ebitRating, UserAverageRating userAverageRating) {
        this.ebitRating = ebitRating;
        this.userAverageRating = userAverageRating;
    }

    public Rating(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        EbitRating _ebitRating = new EbitRating(Util.getJSONObject(jsonObject, "ebitrating"));
        setEbitRating(_ebitRating);

        UserAverageRating _userAverageRating = new UserAverageRating(Util.getJSONObject(jsonObject, "useraveragerating"));
        setUserAverageRating(_userAverageRating);

    }

    public EbitRating getEbitRating() {
        return ebitRating;
    }

    public void setEbitRating(EbitRating ebitRating) {
        this.ebitRating = ebitRating;
    }

    public UserAverageRating getUserAverageRating() {
        return userAverageRating;
    }

    public void setUserAverageRating(UserAverageRating userAverageRating) {
        this.userAverageRating = userAverageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;

        Rating rating = (Rating) o;

        if (getEbitRating() != null ? !getEbitRating().equals(rating.getEbitRating()) : rating.getEbitRating() != null)
            return false;
        return !(getUserAverageRating() != null ? !getUserAverageRating().equals(rating.getUserAverageRating()) : rating.getUserAverageRating() != null);

    }

    @Override
    public int hashCode() {
        int result = getEbitRating() != null ? getEbitRating().hashCode() : 0;
        result = 31 * result + (getUserAverageRating() != null ? getUserAverageRating().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ebitRating=" + ebitRating +
                ", userAverageRating=" + userAverageRating +
                '}';
    }
}
