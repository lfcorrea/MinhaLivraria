package com.lf.minhalivraria.model.buscape_old;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Format implements JSONObjectConverter {

    private long width;
    private String url;
    private long height;

    public Format() {
    }

    public Format(long width, String url, long height) {
        this.width = width;
        this.url = url;
        this.height = height;
    }

    public Format(JSONObject jsonObject) throws JSONException {

        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        long _width = Util.getLong(jsonObject, "width");
        setWidth(_width);

        String _url = Util.getString(jsonObject, "url");
        setUrl(_url);

        long _height = Util.getLong(jsonObject, "height");
        setHeight(_height);

    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Format)) return false;

        Format format = (Format) o;

        if (getWidth() != format.getWidth()) return false;
        if (getHeight() != format.getHeight()) return false;
        return !(getUrl() != null ? !getUrl().equals(format.getUrl()) : format.getUrl() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getWidth() ^ (getWidth() >>> 32));
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (int) (getHeight() ^ (getHeight() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Format{" +
                "width=" + width +
                ", url='" + url + '\'' +
                ", height=" + height +
                '}';
    }
}
