package com.lf.minhalivraria.model.buscape;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public interface JSONObjectConverter {

    public void toJSON();

    public void fromJSON(JSONObject jsonObject) throws JSONException;

}
