package com.lf.minhalivraria.model.buscape;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/3/15.
 */
public class Util {

    public static Link[] getLinks(JSONObject jsonObject) throws JSONException {

        Link[] _links = null;

        JSONArray _linksArray = Util.getJSONArray(jsonObject, "links");
        int size = _linksArray.length();
        _links = new Link[size];

        for (int i = 0; i < size; i++) {
            Link _link = new Link(_linksArray.getJSONObject(i));
            _links[i] = _link;
        }

        return _links;
    }

    public static int getInt(JSONObject jsonObject, String key) throws JSONException {

        int result = 0;

        if (jsonObject.has(key)) {
            result = jsonObject.getInt(key);
        }

        return result;

    }

    public static long getLong(JSONObject jsonObject, String key) throws JSONException {

        long result = 0;

        if (jsonObject.has(key)) {
            result = jsonObject.getLong(key);
        }

        return result;
    }

    public static double getDouble(JSONObject jsonObject, String key) throws JSONException {

        double result = 0.0;

        if (jsonObject.has(key)) {
            result = jsonObject.getDouble(key);
        }

        return result;
    }

    public static boolean getBoolean(JSONObject jsonObject, String key) throws JSONException {

        boolean result = false;

        if (jsonObject.has(key)) {
            result = jsonObject.getBoolean(key);
        }

        return result;
    }

    public static String getString(JSONObject jsonObject, String key) throws JSONException {

        String result = "";

        if (jsonObject.has(key)) {
            result = jsonObject.getString(key);
        }

        return result;
    }

    public static JSONObject getJSONObject(JSONObject jsonObject, String key) throws JSONException {

        JSONObject result = null;

        if (jsonObject.has(key)) {
            result = jsonObject.getJSONObject(key);
        } else {
            result = new JSONObject();
        }

        return result;
    }

    public static JSONArray getJSONArray(JSONObject jsonObject, String key) throws JSONException {

        JSONArray result = null;

        if (jsonObject.has(key)) {
            result = jsonObject.getJSONArray(key);
        } else {
            result = new JSONArray();
        }

        return result;
    }

    public static String sanitizeUrl(String url){

        String result = url;

        if(result!=null){

            result = result.replace("\\/", "/");

        }

        return result;

    }
}
