package com.lf.minhalivraria.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 7/13/15.
 */
public class SaleInfo {
    private String country;
    private String saleability;
    private boolean isEbook;

    public SaleInfo() {
    }

    public SaleInfo(String country, String saleability, boolean isEbook) {
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
    }

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        String _country = jsonObject.getString("country");
        setCountry(_country);

        String _saleability = jsonObject.getString("saleability");
        setSaleability(_saleability);

        boolean _isEbook = jsonObject.getBoolean("isEbook");
        setIsEbook(_isEbook);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setIsEbook(boolean isEbook) {
        this.isEbook = isEbook;
    }
}
