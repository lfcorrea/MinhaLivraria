package com.lf.minhalivraria.model.buscape.offer.seller;

import com.lf.minhalivraria.model.buscape.JSONObjectConverter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Contact implements JSONObjectConverter {

    private String label;
    private String value;

    public Contact() {

    }

    public Contact(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public Contact(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {
        //@TODO
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        String _label = jsonObject.getString("label");
        setLabel(_label);

        String _value = jsonObject.getString("value");
        setValue(_value);

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (!getLabel().equals(contact.getLabel())) return false;
        return getValue().equals(contact.getValue());

    }

    @Override
    public int hashCode() {
        int result = getLabel().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
