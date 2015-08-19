package com.lf.minhalivraria.model.buscape_old.offer.seller.price;

import com.lf.minhalivraria.model.buscape_old.JSONObjectConverter;
import com.lf.minhalivraria.model.buscape_old.Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Parcel implements JSONObjectConverter {

    private int number;
    private int interest;
    private double value;

    public Parcel() {

    }

    public Parcel(int number, float value, int interest) {
        this.number = number;
        this.value = value;
        this.interest = interest;
    }

    public Parcel(JSONObject jsonObject) throws JSONException {

        this.fromJSON(jsonObject);

    }

    @Override
    public void toJSON() {
        //@TODO
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        int _number = Util.getInt(jsonObject, "number");
        setNumber(_number);

        int _interest = Util.getInt(jsonObject, "interest");
        setInterest(_interest);

        double _value = Util.getDouble(jsonObject, "value");
        setValue(_value);

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Parcel)) return false;

        Parcel parcel = (Parcel) o;

        if (getNumber() != parcel.getNumber()) return false;
        if (getInterest() != parcel.getInterest()) return false;

        return Double.compare(parcel.getValue(), getValue()) == 0;

    }

    @Override
    public int hashCode() {

        int result;
        long temp;

        result = getNumber();
        result = 31 * result + getInterest();
        temp = Double.doubleToLongBits(getValue());
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;

    }

    @Override
    public String toString() {

        return "Parcel{" +
                "number=" + number +
                ", interest=" + interest +
                ", value=" + value +
                '}';

    }
}
