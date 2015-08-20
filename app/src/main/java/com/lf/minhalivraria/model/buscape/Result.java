package com.lf.minhalivraria.model.buscape;

import java.util.Arrays;

public class Result {
//    private Product[] products;
    private Product product;

    private Category category;

    private Details details;

    private boolean schk;

    private long page;

    private int totalresultssellers;

    private int totallooseoffers;

    private int totalresultsavailable;

    private String idpg;

    private int totalpages;

    private Offer[] offer;

    private String match;

    private int totalresultsreturned;

    public Result() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public boolean isSchk() {
        return schk;
    }

    public void setSchk(boolean schk) {
        this.schk = schk;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public int getTotalresultssellers() {
        return totalresultssellers;
    }

    public void setTotalresultssellers(int totalresultssellers) {
        this.totalresultssellers = totalresultssellers;
    }

    public int getTotallooseoffers() {
        return totallooseoffers;
    }

    public void setTotallooseoffers(int totallooseoffers) {
        this.totallooseoffers = totallooseoffers;
    }

    public int getTotalresultsavailable() {
        return totalresultsavailable;
    }

    public void setTotalresultsavailable(int totalresultsavailable) {
        this.totalresultsavailable = totalresultsavailable;
    }

    public String getIdpg() {
        return idpg;
    }

    public void setIdpg(String idpg) {
        this.idpg = idpg;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    public Offer[] getOffer() {
        return offer;
    }

    public void setOffer(Offer[] offer) {
        this.offer = offer;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public int getTotalresultsreturned() {
        return totalresultsreturned;
    }

    public void setTotalresultsreturned(int totalresultsreturned) {
        this.totalresultsreturned = totalresultsreturned;
    }

    @Override
    public String toString() {
        return "Result{" +
                "products=" + product +
                ", category=" + category +
                ", details=" + details +
                ", schk='" + schk + '\'' +
                ", page='" + page + '\'' +
                ", totalresultssellers='" + totalresultssellers + '\'' +
                ", totallooseoffers='" + totallooseoffers + '\'' +
                ", totalresultsavailable='" + totalresultsavailable + '\'' +
                ", idpg='" + idpg + '\'' +
                ", totalpages='" + totalpages + '\'' +
                ", offer=" + Arrays.toString(offer) +
                ", match='" + match + '\'' +
                ", totalresultsreturned='" + totalresultsreturned + '\'' +
                '}';
    }
}
