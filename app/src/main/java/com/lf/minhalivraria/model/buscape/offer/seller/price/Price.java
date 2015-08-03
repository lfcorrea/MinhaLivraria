package com.lf.minhalivraria.model.buscape.offer.seller.price;

import com.lf.minhalivraria.model.buscape.JSONObjectConverter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Price implements JSONObjectConverter {

    private Parcel parcel;
    private String currencyAbbreviation;
    private double value;

    public Price() {

    }

    public Price(Parcel parcel, String currencyAbbreviation, double value) {

        this.parcel = parcel;
        this.currencyAbbreviation = currencyAbbreviation;
        this.value = value;

    }

    public Price(JSONObject jsonObject) throws JSONException {

        this.fromJSON(jsonObject);

    }

    @Override
    public void toJSON() {
        //@TODO
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        JSONObject _parcelObject = jsonObject.getJSONObject("parcel");
        Parcel _parcel = new Parcel(_parcelObject);
        setParcel(_parcel);

        String _currencyAbbreviation = jsonObject.getJSONObject("currency").getString("abbreviation");
        setCurrencyAbbreviation(_currencyAbbreviation);

        double _value = jsonObject.getDouble("value");
        setValue(_value);

    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price price = (Price) o;

        if (Double.compare(price.getValue(), getValue()) != 0) return false;
        if (!getParcel().equals(price.getParcel())) return false;
        return getCurrencyAbbreviation().equals(price.getCurrencyAbbreviation());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getParcel().hashCode();
        result = 31 * result + getCurrencyAbbreviation().hashCode();
        temp = Double.doubleToLongBits(getValue());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "parcel=" + parcel +
                ", currencyAbbreviation='" + currencyAbbreviation + '\'' +
                ", value=" + value +
                '}';
    }
}
