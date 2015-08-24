package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;
import java.util.Arrays;

public class Offer implements Serializable {
    private long id;

    private long categoryid;

    private Price price;

    private Thumbnail thumbnail;

    private long productid;

    private Links[] links;

    private String offername;

    private Seller seller;

    private String offershortname;

    public Offer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public Links[] getLinks() {
        return links;
    }

    public void setLinks(Links[] links) {
        this.links = links;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getOffershortname() {
        return offershortname;
    }

    public void setOffershortname(String offershortname) {
        this.offershortname = offershortname;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", categoryid='" + categoryid + '\'' +
                ", price=" + price +
                ", thumbnail=" + thumbnail +
                ", productid='" + productid + '\'' +
                ", links=" + Arrays.toString(links) +
                ", offername='" + offername + '\'' +
                ", seller=" + seller +
                ", offershortname='" + offershortname + '\'' +
                '}';
    }
}
