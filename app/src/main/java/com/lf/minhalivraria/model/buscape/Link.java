package com.lf.minhalivraria.model.buscape;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Link implements JSONObjectConverter {

    private String url;
    private String type;

    public Link() {
    }

    public Link(String url, String type) {
        this.url = url;
        this.type = type;
    }

    public Link(JSONObject jsonObject) throws JSONException {

        this.fromJSON(jsonObject);

    }

    @Override
    public void toJSON() {

        //@TODO

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        String _url = jsonObject.getString("url");
        setUrl(_url);

        String _type = jsonObject.getString("type");
        setType(_type);

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;

        Link link = (Link) o;

        if (!getUrl().equals(link.getUrl())) return false;
        return getType().equals(link.getType());

    }

    @Override
    public int hashCode() {
        int result = getUrl().hashCode();
        result = 31 * result + getType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
