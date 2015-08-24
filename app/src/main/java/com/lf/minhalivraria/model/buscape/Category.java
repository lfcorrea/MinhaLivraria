package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;
import java.util.Arrays;

public class Category implements Serializable {
    private long id;

    private Thumbnail thumbnail;

    private boolean concatenatecategoryname;

    private String name;

    private boolean hasoffer;

    private Links[] links;

    private long parentcategoryid;

    private boolean isfinal;

    public Category() {
    }

    public boolean isfinal() {
        return isfinal;
    }

    public void setIsfinal(boolean isfinal) {
        this.isfinal = isfinal;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isConcatenatecategoryname() {
        return concatenatecategoryname;
    }

    public void setConcatenatecategoryname(boolean concatenatecategoryname) {
        this.concatenatecategoryname = concatenatecategoryname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasoffer() {
        return hasoffer;
    }

    public void setHasoffer(boolean hasoffer) {
        this.hasoffer = hasoffer;
    }

    public Links[] getLinks() {
        return links;
    }

    public void setLinks(Links[] links) {
        this.links = links;
    }

    public long getParentcategoryid() {
        return parentcategoryid;
    }

    public void setParentcategoryid(long parentcategoryid) {
        this.parentcategoryid = parentcategoryid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", thumbnail=" + thumbnail +
                ", concatenatecategoryname='" + concatenatecategoryname + '\'' +
                ", name='" + name + '\'' +
                ", hasoffer='" + hasoffer + '\'' +
                ", links=" + Arrays.toString(links) +
                ", parentcategoryid='" + parentcategoryid + '\'' +
                ", isfinal='" + isfinal + '\'' +
                '}';
    }
}
