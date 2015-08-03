package com.lf.minhalivraria.model.buscape.offer;

import com.lf.minhalivraria.model.buscape.JSONObjectConverter;
import com.lf.minhalivraria.model.buscape.Link;
import com.lf.minhalivraria.model.buscape.offer.seller.price.Price;
import com.lf.minhalivraria.model.buscape.offer.seller.Seller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Offer implements JSONObjectConverter {

    private Seller seller;
    private String thumbnailUrl;
    private long productId;
    private String offerName;

    private Price price;

    private Link[] links;

    private String offerShortName;
    private long id;
    private long categoryId;

    public Offer() {
    }

    public Offer(Seller seller, String thumbnailUrl, long productId, String offerName, Price price, Link[] links, String offerShortName, long id, long categoryId) {
        this.seller = seller;
        this.thumbnailUrl = thumbnailUrl;
        this.productId = productId;
        this.offerName = offerName;
        this.price = price;
        this.links = links;
        this.offerShortName = offerShortName;
        this.id = id;
        this.categoryId = categoryId;
    }

    public Offer(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        Seller _seller = new Seller(jsonObject.getJSONObject("seller"));
        setSeller(_seller);

        String _thumbnailUrl = jsonObject.getJSONObject("thumbnail").getString("url");
        setThumbnailUrl(_thumbnailUrl);

        long _productId = jsonObject.getLong("productid");
        setProductId(_productId);

        String _offerName = jsonObject.getString("offername");
        setOfferName(_offerName);

        Price _price = new Price(jsonObject.getJSONObject("price"));
        setPrice(_price);

        setLinks(getLinks(jsonObject));

        String _offerShortName = jsonObject.getString("offershortname");
        setOfferShortName(_offerShortName);

        long _id = jsonObject.getLong("id");
        setId(_id);

        long _categoryId = jsonObject.getLong("categoryid");
        setCategoryId(_categoryId);

    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    public String getOfferShortName() {
        return offerShortName;
    }

    public void setOfferShortName(String offerShortName) {
        this.offerShortName = offerShortName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;

        Offer offer = (Offer) o;

        if (getProductId() != offer.getProductId()) return false;
        if (getId() != offer.getId()) return false;
        if (getCategoryId() != offer.getCategoryId()) return false;
        if (getSeller() != null ? !getSeller().equals(offer.getSeller()) : offer.getSeller() != null)
            return false;
        if (getThumbnailUrl() != null ? !getThumbnailUrl().equals(offer.getThumbnailUrl()) : offer.getThumbnailUrl() != null)
            return false;
        if (getOfferName() != null ? !getOfferName().equals(offer.getOfferName()) : offer.getOfferName() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(offer.getPrice()) : offer.getPrice() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getLinks(), offer.getLinks())) return false;
        return !(getOfferShortName() != null ? !getOfferShortName().equals(offer.getOfferShortName()) : offer.getOfferShortName() != null);

    }

    @Override
    public int hashCode() {
        int result = getSeller() != null ? getSeller().hashCode() : 0;
        result = 31 * result + (getThumbnailUrl() != null ? getThumbnailUrl().hashCode() : 0);
        result = 31 * result + (int) (getProductId() ^ (getProductId() >>> 32));
        result = 31 * result + (getOfferName() != null ? getOfferName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getLinks() != null ? Arrays.hashCode(getLinks()) : 0);
        result = 31 * result + (getOfferShortName() != null ? getOfferShortName().hashCode() : 0);
        result = 31 * result + (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (int) (getCategoryId() ^ (getCategoryId() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "seller=" + seller +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", productId=" + productId +
                ", offerName='" + offerName + '\'' +
                ", price=" + price +
                ", links=" + Arrays.toString(links) +
                ", offerShortName='" + offerShortName + '\'' +
                ", id=" + id +
                ", categoryId=" + categoryId +
                '}';
    }
}
