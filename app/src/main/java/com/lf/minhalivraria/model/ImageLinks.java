package com.lf.minhalivraria.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 7/25/15.
 */
public class ImageLinks {

    private String smallThumbnail;
    private String thumbnail;

    public ImageLinks() {
    }

    public ImageLinks(String thumbnail, String smallThumbnail) {
        this.thumbnail = thumbnail;
        this.smallThumbnail = smallThumbnail;
    }

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        if(jsonObject.has("smallThumbnail")) {
            String _smallThumbnail = jsonObject.getString("smallThumbnail");
            setSmallThumbnail(_smallThumbnail);
        }

        if(jsonObject.has("thumbnail")) {
            String _thumbnail = jsonObject.getString("thumbnail");
            setThumbnail(_thumbnail);
        }

    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
