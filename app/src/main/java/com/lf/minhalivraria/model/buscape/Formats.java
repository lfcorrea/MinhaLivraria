package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Formats implements Serializable {
    private long height;

    private String width;

    private long url;

    public Formats() {
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public long getUrl() {
        return url;
    }

    public void setUrl(long url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Formats{" +
                "height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
