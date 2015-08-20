package com.lf.minhalivraria.model.buscape;

import java.util.Arrays;

public class Thumbnail {
    private int height;

    private int width;

    private String url;

//    private Formats[] formats;

    public Thumbnail() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public Formats[] getFormats() {
//        return formats;
//    }
//
//    public void setFormats(Formats[] formats) {
//        this.formats = formats;
//    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", url='" + url + '\'' +
//                ", formats=" + Arrays.toString(formats) +
                '}';
    }
}
