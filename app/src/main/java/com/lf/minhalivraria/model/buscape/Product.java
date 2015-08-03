package com.lf.minhalivraria.model.buscape;

import com.lf.minhalivraria.model.buscape.offer.seller.UserAverageRating;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Product implements JSONObjectConverter {

    private Thumbnail thumbnail;
    private double priceMax;
    private long quantity;

    private UserAverageRating rating;
    private Specification specification;

    private boolean hasMetaSearch;
    private boolean eco;
    private double priceMin;
    private long numberOffers;
    private long totalSellers;
    private String productName;
    private boolean fullDescription;
    private Link[] links;
    private String currencyAbbreviation;
    private long id;
    private long categoryId;

    public Product() {
    }

    public Product(Thumbnail thumbnail, double priceMax, long quantity, UserAverageRating rating, Specification specification, boolean hasMetaSearch, boolean eco, double priceMin, long numberOffers, long totalSellers, String productName, boolean fullDescription, Link[] links, String currencyAbbreviation, long id, long categoryId) {
        this.thumbnail = thumbnail;
        this.priceMax = priceMax;
        this.quantity = quantity;
        this.rating = rating;
        this.specification = specification;
        this.hasMetaSearch = hasMetaSearch;
        this.eco = eco;
        this.priceMin = priceMin;
        this.numberOffers = numberOffers;
        this.totalSellers = totalSellers;
        this.productName = productName;
        this.fullDescription = fullDescription;
        this.links = links;
        this.currencyAbbreviation = currencyAbbreviation;
        this.id = id;
        this.categoryId = categoryId;
    }

    public Product(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        Thumbnail _thumbnail = new Thumbnail(jsonObject.getJSONObject("thumbnail"));
        setThumbnail(_thumbnail);

        Double _priceMax = jsonObject.getDouble("pricemax");
        setPriceMax(_priceMax);

        long _quantity = jsonObject.getLong("quantity");
        setQuantity(_quantity);

        UserAverageRating _userAverageRating = new UserAverageRating(jsonObject.getJSONObject("rating").getJSONObject("useraveragerating"));
        setRating(_userAverageRating);

        Specification _specification = new Specification(jsonObject.getJSONObject("specification"));
        setSpecification(_specification);

        boolean _hasMetaSearch = jsonObject.getBoolean("hasmetasearch");
        setHasMetaSearch(_hasMetaSearch);

        boolean _eco = jsonObject.getBoolean("eco");
        setEco(_eco);

        double _priceMin = jsonObject.getDouble("pricemin");
        setPriceMin(_priceMin);

        long _numberOfOffers = jsonObject.getLong("numoffers");
        setNumberOffers(_numberOfOffers);

        long _totalSellers = jsonObject.getLong("totalsellers");
        setTotalSellers(_totalSellers);

        String _productName = jsonObject.getString("productname");
        setProductName(_productName);

        boolean _fullDescription = jsonObject.getBoolean("fulldescription");
        setFullDescription(_fullDescription);

        setLinks(getLinks(jsonObject));

        String _currencyAbbreviation = jsonObject.getJSONObject("currency").getString("abbreviation");
        setCurrencyAbbreviation(_currencyAbbreviation);

        long _id = jsonObject.getLong("id");
        setId(_id);

        long _categoryId = jsonObject.getLong("categoryid");
        setCategoryId(_categoryId);

    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(double priceMax) {
        this.priceMax = priceMax;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public UserAverageRating getRating() {
        return rating;
    }

    public void setRating(UserAverageRating rating) {
        this.rating = rating;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public boolean isHasMetaSearch() {
        return hasMetaSearch;
    }

    public void setHasMetaSearch(boolean hasMetaSearch) {
        this.hasMetaSearch = hasMetaSearch;
    }

    public boolean isEco() {
        return eco;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
    }

    public double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(double priceMin) {
        this.priceMin = priceMin;
    }

    public long getNumberOffers() {
        return numberOffers;
    }

    public void setNumberOffers(long numberOffers) {
        this.numberOffers = numberOffers;
    }

    public long getTotalSellers() {
        return totalSellers;
    }

    public void setTotalSellers(long totalSellers) {
        this.totalSellers = totalSellers;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(boolean fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
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
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPriceMax(), getPriceMax()) != 0) return false;
        if (getQuantity() != product.getQuantity()) return false;
        if (isHasMetaSearch() != product.isHasMetaSearch()) return false;
        if (isEco() != product.isEco()) return false;
        if (Double.compare(product.getPriceMin(), getPriceMin()) != 0) return false;
        if (getNumberOffers() != product.getNumberOffers()) return false;
        if (getTotalSellers() != product.getTotalSellers()) return false;
        if (isFullDescription() != product.isFullDescription()) return false;
        if (getId() != product.getId()) return false;
        if (getCategoryId() != product.getCategoryId()) return false;
        if (getThumbnail() != null ? !getThumbnail().equals(product.getThumbnail()) : product.getThumbnail() != null)
            return false;
        if (getRating() != null ? !getRating().equals(product.getRating()) : product.getRating() != null)
            return false;
        if (getSpecification() != null ? !getSpecification().equals(product.getSpecification()) : product.getSpecification() != null)
            return false;
        if (getProductName() != null ? !getProductName().equals(product.getProductName()) : product.getProductName() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getLinks(), product.getLinks())) return false;
        return !(getCurrencyAbbreviation() != null ? !getCurrencyAbbreviation().equals(product.getCurrencyAbbreviation()) : product.getCurrencyAbbreviation() != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getThumbnail() != null ? getThumbnail().hashCode() : 0;
        temp = Double.doubleToLongBits(getPriceMax());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (getQuantity() ^ (getQuantity() >>> 32));
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (getSpecification() != null ? getSpecification().hashCode() : 0);
        result = 31 * result + (isHasMetaSearch() ? 1 : 0);
        result = 31 * result + (isEco() ? 1 : 0);
        temp = Double.doubleToLongBits(getPriceMin());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (getNumberOffers() ^ (getNumberOffers() >>> 32));
        result = 31 * result + (int) (getTotalSellers() ^ (getTotalSellers() >>> 32));
        result = 31 * result + (getProductName() != null ? getProductName().hashCode() : 0);
        result = 31 * result + (isFullDescription() ? 1 : 0);
        result = 31 * result + (getLinks() != null ? Arrays.hashCode(getLinks()) : 0);
        result = 31 * result + (getCurrencyAbbreviation() != null ? getCurrencyAbbreviation().hashCode() : 0);
        result = 31 * result + (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (int) (getCategoryId() ^ (getCategoryId() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "thumbnail=" + thumbnail +
                ", priceMax=" + priceMax +
                ", quantity=" + quantity +
                ", rating=" + rating +
                ", specification=" + specification +
                ", hasMetaSearch=" + hasMetaSearch +
                ", eco=" + eco +
                ", priceMin=" + priceMin +
                ", numberOffers=" + numberOffers +
                ", totalSellers=" + totalSellers +
                ", productName='" + productName + '\'' +
                ", fullDescription=" + fullDescription +
                ", links=" + Arrays.toString(links) +
                ", currencyAbbreviation='" + currencyAbbreviation + '\'' +
                ", id=" + id +
                ", categoryId=" + categoryId +
                '}';
    }
}
