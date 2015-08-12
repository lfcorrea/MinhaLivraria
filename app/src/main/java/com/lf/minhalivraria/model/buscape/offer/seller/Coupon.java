package com.lf.minhalivraria.model.buscape.offer.seller;

import com.lf.minhalivraria.model.buscape.JSONObjectConverter;
import com.lf.minhalivraria.model.buscape.Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/2/15.
 */
public class Coupon implements JSONObjectConverter {

    private long id;
    private String type;

    public Coupon() {
    }

    public Coupon(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Coupon(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        long _id = Util.getLong(jsonObject, "id");
        setId(_id);

        String _type = Util.getString(jsonObject, "type");
        setType(_type);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon)) return false;

        Coupon coupon = (Coupon) o;

        if (getId() != coupon.getId()) return false;
        return !(getType() != null ? !getType().equals(coupon.getType()) : coupon.getType() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
