package com.lf.minhalivraria.model.buscape_old;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Thumbnail implements JSONObjectConverter {

    private Format[] formats;

    private long width;
    private String url;
    private long height;

    public Thumbnail() {
    }

    public Thumbnail(Format[] formats, long width, String url, long height) {
        this.formats = formats;
        this.width = width;
        this.url = url;
        this.height = height;
    }

    public Thumbnail(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        JSONArray _formatsArray = Util.getJSONArray(jsonObject, "formats");
        int size = _formatsArray.length();
        Format[] _formats = new Format[size];

        for (int i = 0; i < size; i++) {
            JSONObject _formatJSON = Util.getJSONObject((JSONObject)_formatsArray.get(i),"formats");
            Format _format = new Format(_formatJSON);
            _formats[i] = _format;
        }
        setFormats(_formats);

        long _width = Util.getLong(jsonObject, "width");
        setWidth(_width);

        String _url = Util.getString(jsonObject, "url");
        setUrl(_url);

        long _height = Util.getLong(jsonObject, "height");
        setHeight(_height);
    }

    public Format[] getFormats() {
        return formats;
    }

    public void setFormats(Format[] formats) {
        this.formats = formats;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public String getUrl() {
        return Util.sanitizeUrl(url);
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
        if (!(o instanceof Thumbnail)) return false;

        Thumbnail thumbnail = (Thumbnail) o;

        if (getWidth() != thumbnail.getWidth()) return false;
        if (getHeight() != thumbnail.getHeight()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getFormats(), thumbnail.getFormats())) return false;
        return !(getUrl() != null ? !getUrl().equals(thumbnail.getUrl()) : thumbnail.getUrl() != null);

    }

    @Override
    public int hashCode() {
        int result = getFormats() != null ? Arrays.hashCode(getFormats()) : 0;
        result = 31 * result + (int) (getWidth() ^ (getWidth() >>> 32));
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (int) (getHeight() ^ (getHeight() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "formats=" + Arrays.toString(formats) +
                ", width=" + width +
                ", url='" + url + '\'' +
                ", height=" + height +
                '}';
    }
}
