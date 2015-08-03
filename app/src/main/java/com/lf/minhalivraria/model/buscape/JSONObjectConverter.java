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

    public default Link[] getLinks(JSONObject jsonObject) throws JSONException {

        Link[] _links = null;

        if (jsonObject.has("links")) {

            JSONArray _linksArray = jsonObject.getJSONArray("links");
            int size = _linksArray.length();
            _links = new Link[size];

            for (int i = 0; i < size; i++) {
                Link _link = new Link(_linksArray.getJSONObject(i));
                _links[i] = _link;
            }


        } else {

            _links = new Link[0];

        }

        return _links;
    }
}
