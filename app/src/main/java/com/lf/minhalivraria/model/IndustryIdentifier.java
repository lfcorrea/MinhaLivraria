package com.lf.minhalivraria.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 7/13/15.
 */
public class IndustryIdentifier {
    private String type;
    private String identifier;

    public IndustryIdentifier() {
    }

    public IndustryIdentifier(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        String _type = jsonObject.getString("type");
        setType(_type);

        String _indentifier = jsonObject.getString("identifier");
        setIdentifier(_indentifier);

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
