package com.lf.minhalivraria.model.buscape;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Item implements JSONObjectConverter {

    private String label;
    private String[] value;

    public Item() {
    }

    public Item(String label, String[] value) {
        this.label = label;
        this.value = value;
    }

    public Item(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        String _label = jsonObject.getString("label");
        setLabel(_label);

        JSONArray _valuesArray = jsonObject.getJSONArray("value");
        int size = _valuesArray.length();
        String[] _values = new String[size];
        for (int i = 0; i < size; i++) {
            String value = _valuesArray.getString(i);
            _values[i] = value;
        }
        setValue(_values);

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (getLabel() != null ? !getLabel().equals(item.getLabel()) : item.getLabel() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getValue(), item.getValue());

    }

    @Override
    public int hashCode() {
        int result = getLabel() != null ? getLabel().hashCode() : 0;
        result = 31 * result + (getValue() != null ? Arrays.hashCode(getValue()) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "label='" + label + '\'' +
                ", value=" + Arrays.toString(value) +
                '}';
    }
}
