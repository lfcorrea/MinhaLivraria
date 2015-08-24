package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;
import java.util.Arrays;

public class Product implements Serializable {

    private long totalsellers;

    private boolean fulldescription;

    private double pricemax;

    private boolean hasmetasearch;

    private Links[] links;

    private double pricemin;

    private long numoffers;

    private Currency currency;

    private long id;

    private int categoryid;

    private Thumbnail thumbnail;

    private Specification specification;

    private long quantity;

    private Rating rating;

    private boolean eco;

    private String productname;

    public Product() {
    }

    public long getTotalsellers() {
        return totalsellers;
    }

    public void setTotalsellers(long totalsellers) {
        this.totalsellers = totalsellers;
    }

    public boolean isFulldescription() {
        return fulldescription;
    }

    public void setFulldescription(boolean fulldescription) {
        this.fulldescription = fulldescription;
    }

    public double getPricemax() {
        return pricemax;
    }

    public void setPricemax(double pricemax) {
        this.pricemax = pricemax;
    }

    public boolean isHasmetasearch() {
        return hasmetasearch;
    }

    public void setHasmetasearch(boolean hasmetasearch) {
        this.hasmetasearch = hasmetasearch;
    }

    public Links[] getLinks() {
        return links;
    }

    public void setLinks(Links[] links) {
        this.links = links;
    }

    public double getPricemin() {
        return pricemin;
    }

    public void setPricemin(double pricemin) {
        this.pricemin = pricemin;
    }

    public long getNumoffers() {
        return numoffers;
    }

    public void setNumoffers(long numoffers) {
        this.numoffers = numoffers;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isEco() {
        return eco;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Override
    public String toString() {
        return "Product{" +
                "  totalsellers=" + totalsellers +
                ", fulldescription=" + fulldescription +
                ", pricemax=" + pricemax +
                ", hasmetasearch=" + hasmetasearch +
                ", links=" + Arrays.toString(links) +
                ", pricemin=" + pricemin +
                ", numoffers=" + numoffers +
                ", currency=" + currency +
                ", id=" + id +
                ", categoryid=" + categoryid +
                ", thumbnail=" + thumbnail +
                ", specification=" + specification +
                ", quantity=" + quantity +
                ", rating=" + rating +
                ", eco=" + eco +
                ", productname='" + productname + '\'' +
                '}';
    }
}