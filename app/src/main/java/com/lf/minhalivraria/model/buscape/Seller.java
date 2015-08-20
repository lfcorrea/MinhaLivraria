package com.lf.minhalivraria.model.buscape;

import java.util.Arrays;

public class Seller {
    private int id;

    private boolean oneclickbuy;

    private Thumbnail thumbnail;

    private int oneclickbuyvalue;

    private int advertiserid;

    private boolean cpcdifferentiated;

    private String sellername;

    private Link[] links;

    private Rating rating;

    private boolean istrustedstore;

    private Contacts[] contacts;

    private boolean pagamentodigital;

    public Seller() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOneclickbuy() {
        return oneclickbuy;
    }

    public void setOneclickbuy(boolean oneclickbuy) {
        this.oneclickbuy = oneclickbuy;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getOneclickbuyvalue() {
        return oneclickbuyvalue;
    }

    public void setOneclickbuyvalue(int oneclickbuyvalue) {
        this.oneclickbuyvalue = oneclickbuyvalue;
    }

    public int getAdvertiserid() {
        return advertiserid;
    }

    public void setAdvertiserid(int advertiserid) {
        this.advertiserid = advertiserid;
    }

    public boolean isCpcdifferentiated() {
        return cpcdifferentiated;
    }

    public void setCpcdifferentiated(boolean cpcdifferentiated) {
        this.cpcdifferentiated = cpcdifferentiated;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean istrustedstore() {
        return istrustedstore;
    }

    public void setIstrustedstore(boolean istrustedstore) {
        this.istrustedstore = istrustedstore;
    }

    public Contacts[] getContacts() {
        return contacts;
    }

    public void setContacts(Contacts[] contacts) {
        this.contacts = contacts;
    }

    public boolean isPagamentodigital() {
        return pagamentodigital;
    }

    public void setPagamentodigital(boolean pagamentodigital) {
        this.pagamentodigital = pagamentodigital;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id='" + id + '\'' +
                ", oneclickbuy='" + oneclickbuy + '\'' +
                ", thumbnail=" + thumbnail +
                ", oneclickbuyvalue='" + oneclickbuyvalue + '\'' +
                ", advertiserid='" + advertiserid + '\'' +
                ", cpcdifferentiated='" + cpcdifferentiated + '\'' +
                ", sellername='" + sellername + '\'' +
                ", links=" + Arrays.toString(links) +
                ", rating=" + rating +
                ", istrustedstore='" + istrustedstore + '\'' +
                ", contacts=" + Arrays.toString(contacts) +
                ", pagamentodigital='" + pagamentodigital + '\'' +
                '}';
    }
}
