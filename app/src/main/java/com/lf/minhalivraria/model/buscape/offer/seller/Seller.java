package com.lf.minhalivraria.model.buscape.offer.seller;

import com.lf.minhalivraria.model.buscape.JSONObjectConverter;
import com.lf.minhalivraria.model.buscape.Link;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Seller implements JSONObjectConverter {

    private boolean isTrustedstore;
    private boolean pagamentoDigital;
    private String thumbnailUrl;

    private Rating rating;
    private boolean cpcDifferentiated;

    private Link[] links;

    private String sellerName;
    private boolean oneClickBuy;
    private long oneClickBuyValue;
    private long id;

    private Contact[] contacts;

    private long advertiserId;

    private Coupon coupon;

    public Seller() {
    }

    public Seller(boolean isTrustedstore, boolean pagamentoDigital, String thumbnailUrl, Rating rating, boolean cpcDifferentiated, Link[] links, String sellerName, boolean oneClickBuy, long oneClickBuyValue, long id, Contact[] contacts, long advertiserId, Coupon coupon) {
        this.isTrustedstore = isTrustedstore;
        this.pagamentoDigital = pagamentoDigital;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
        this.cpcDifferentiated = cpcDifferentiated;
        this.links = links;
        this.sellerName = sellerName;
        this.oneClickBuy = oneClickBuy;
        this.oneClickBuyValue = oneClickBuyValue;
        this.id = id;
        this.contacts = contacts;
        this.advertiserId = advertiserId;
        this.coupon = coupon;
    }

    public Seller(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {
        //@TODO
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        boolean _isTrustedStore = jsonObject.getBoolean("istrustedstore");
        setIsTrustedstore(_isTrustedStore);

        boolean _pagamentoDigital = jsonObject.getBoolean("pagamentodigital");
        setPagamentoDigital(_pagamentoDigital);

        String _thumbnailUrl = jsonObject.getJSONObject("thumbnail").getString("url");
        setThumbnailUrl(_thumbnailUrl);

        Rating _rating = new Rating(jsonObject.getJSONObject("rating"));
        setRating(_rating);

        boolean _cpcDifferentiated = jsonObject.getBoolean("cpcdifferentiated");
        setCpcDifferentiated(_cpcDifferentiated);

        setLinks(getLinks(jsonObject));

        String _sellerName = jsonObject.getString("sellername");
        setSellerName(_sellerName);

        boolean _oneClickBuy = jsonObject.getBoolean("oneclickbuy");
        setOneClickBuy(_oneClickBuy);

        long _id = jsonObject.getLong("id");
        setId(_id);

        if (jsonObject.has("contacts")) {

            JSONArray _contactsArray = jsonObject.getJSONArray("contacts");
            int size = _contactsArray.length();
            Contact[] _contacts = new Contact[size];

            for (int i = 0; i < size; i++) {
                Contact _contact = new Contact(_contactsArray.getJSONObject(i));
                _contacts[i] = _contact;
            }

            setContacts(_contacts);

        } else {

            setContacts(new Contact[0]);

        }

        long _advertiserId = jsonObject.getLong("advertiserid");
        setAdvertiserId(_advertiserId);

        Coupon _coupon = new Coupon(jsonObject.getJSONObject("coupon"));
        setCoupon(_coupon);

    }

    public boolean isTrustedstore() {
        return isTrustedstore;
    }

    public void setIsTrustedstore(boolean isTrustedstore) {
        this.isTrustedstore = isTrustedstore;
    }

    public boolean isPagamentoDigital() {
        return pagamentoDigital;
    }

    public void setPagamentoDigital(boolean pagamentoDigital) {
        this.pagamentoDigital = pagamentoDigital;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isCpcDifferentiated() {
        return cpcDifferentiated;
    }

    public void setCpcDifferentiated(boolean cpcDifferentiated) {
        this.cpcDifferentiated = cpcDifferentiated;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isOneClickBuy() {
        return oneClickBuy;
    }

    public void setOneClickBuy(boolean oneClickBuy) {
        this.oneClickBuy = oneClickBuy;
    }

    public long getOneClickBuyValue() {
        return oneClickBuyValue;
    }

    public void setOneClickBuyValue(long oneClickBuyValue) {
        this.oneClickBuyValue = oneClickBuyValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller)) return false;

        Seller seller = (Seller) o;

        if (isTrustedstore() != seller.isTrustedstore()) return false;
        if (isPagamentoDigital() != seller.isPagamentoDigital()) return false;
        if (isCpcDifferentiated() != seller.isCpcDifferentiated()) return false;
        if (isOneClickBuy() != seller.isOneClickBuy()) return false;
        if (getOneClickBuyValue() != seller.getOneClickBuyValue()) return false;
        if (getId() != seller.getId()) return false;
        if (getAdvertiserId() != seller.getAdvertiserId()) return false;
        if (getThumbnailUrl() != null ? !getThumbnailUrl().equals(seller.getThumbnailUrl()) : seller.getThumbnailUrl() != null)
            return false;
        if (getRating() != null ? !getRating().equals(seller.getRating()) : seller.getRating() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getLinks(), seller.getLinks())) return false;
        if (getSellerName() != null ? !getSellerName().equals(seller.getSellerName()) : seller.getSellerName() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getContacts(), seller.getContacts())) return false;
        return !(getCoupon() != null ? !getCoupon().equals(seller.getCoupon()) : seller.getCoupon() != null);

    }

    @Override
    public int hashCode() {
        int result = (isTrustedstore() ? 1 : 0);
        result = 31 * result + (isPagamentoDigital() ? 1 : 0);
        result = 31 * result + (getThumbnailUrl() != null ? getThumbnailUrl().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (isCpcDifferentiated() ? 1 : 0);
        result = 31 * result + (getLinks() != null ? Arrays.hashCode(getLinks()) : 0);
        result = 31 * result + (getSellerName() != null ? getSellerName().hashCode() : 0);
        result = 31 * result + (isOneClickBuy() ? 1 : 0);
        result = 31 * result + (int) (getOneClickBuyValue() ^ (getOneClickBuyValue() >>> 32));
        result = 31 * result + (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getContacts() != null ? Arrays.hashCode(getContacts()) : 0);
        result = 31 * result + (int) (getAdvertiserId() ^ (getAdvertiserId() >>> 32));
        result = 31 * result + (getCoupon() != null ? getCoupon().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "isTrustedstore=" + isTrustedstore +
                ", pagamentoDigital=" + pagamentoDigital +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", rating=" + rating +
                ", cpcDifferentiated=" + cpcDifferentiated +
                ", links=" + Arrays.toString(links) +
                ", sellerName='" + sellerName + '\'' +
                ", oneClickBuy=" + oneClickBuy +
                ", oneClickBuyValue=" + oneClickBuyValue +
                ", id=" + id +
                ", contacts=" + Arrays.toString(contacts) +
                ", advertiserId=" + advertiserId +
                ", coupon=" + coupon +
                '}';
    }
}
