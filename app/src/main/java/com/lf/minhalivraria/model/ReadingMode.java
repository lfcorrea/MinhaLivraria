package com.lf.minhalivraria.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 7/13/15.
 */
public class ReadingMode {

    private boolean text;
    private boolean image;

    public ReadingMode() {
    }

    public ReadingMode(boolean text, boolean image) {
        this.text = text;
        this.image = image;
    }

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        boolean _text = jsonObject.getBoolean("text");
        setText(_text);

        boolean _image = jsonObject.getBoolean("image");
        setImage(_image);

    }

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }
}
