package com.lf.minhalivraria.model.buscape_old;

import com.lf.minhalivraria.model.buscape_old.offer.Offer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Result implements JSONObjectConverter {

    private Product[] products;
    private String idpg;
    private boolean schk;
    private String match;
    private long totalResultsReturned;
    private long totalResultsAvailable;

    private Offer[] offers;

    private long totalLooseOffers;
    private int totalResultsSellers;

    private Details details;

    private long totalPages;
    private long page;

    private Category category;

    public Result() {
    }

    public Result(Product[] products, String idpg, boolean schk, String match, long totalResultsReturned, long totalResultsAvailable, Offer[] offers, long totalLooseOffers, int totalResultsSellers, Details details, long totalPages, long page, Category category) {
        this.products = products;
        this.idpg = idpg;
        this.schk = schk;
        this.match = match;
        this.totalResultsReturned = totalResultsReturned;
        this.totalResultsAvailable = totalResultsAvailable;
        this.offers = offers;
        this.totalLooseOffers = totalLooseOffers;
        this.totalResultsSellers = totalResultsSellers;
        this.details = details;
        this.totalPages = totalPages;
        this.page = page;
        this.category = category;
    }

    public Result(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        JSONArray _productArray = Util.getJSONArray(jsonObject, "product");
        int sizeProducts = _productArray.length();
        Product[] _products = new Product[sizeProducts];
        for (int i = 0; i < sizeProducts; i++) {
            JSONObject _productJSON = Util.getJSONObject((JSONObject) _productArray.get(i), "product");
            Product _product = new Product(_productJSON);
            _products[i] = _product;
        }
        setProducts(_products);

        String _idpg = Util.getString(jsonObject, "idpg");
        setIdpg(_idpg);

        boolean _schk = Util.getBoolean(jsonObject, "schk");
        setSchk(_schk);

        String _match = Util.getString(jsonObject, "match");
        setMatch(_match);

        long _totalResultsReturned = Util.getLong(jsonObject, "totalresultsreturned");
        setTotalResultsReturned(_totalResultsReturned);

        long _totalResultsAvailable = Util.getLong(jsonObject, "totalresultsavailable");
        setTotalResultsAvailable(_totalResultsAvailable);

        Offer[] _offers = new Offer[0];
        if (jsonObject.has("offer")) {

            JSONArray _offersArray = Util.getJSONArray(jsonObject, "offer");
            int sizeOffer = _offersArray.length();
            _offers = new Offer[sizeOffer];

            for (int i = 0; i < sizeOffer; i++) {
                Offer _offer = new Offer(_offersArray.getJSONObject(i));
                _offers[i] = _offer;
            }

        }
        setOffers(_offers);

        long _totalLooseOffers = Util.getLong(jsonObject, "totallooseoffers");
        setTotalLooseOffers(_totalLooseOffers);

        int _totalResultsSellers = Util.getInt(jsonObject, "totalresultssellers");
        setTotalResultsSellers(_totalResultsSellers);

        Details _details = new Details(Util.getJSONObject(jsonObject, "details"));
        setDetails(_details);

        long _totalPages = Util.getLong(jsonObject, "totalpages");
        setTotalPages(_totalPages);

        long _page = Util.getLong(jsonObject, "page");
        setPage(_page);

        Category _category = new Category(Util.getJSONObject(jsonObject, "category"));
        setCategory(_category);

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public String getIdpg() {
        return idpg;
    }

    public void setIdpg(String idpg) {
        this.idpg = idpg;
    }

    public boolean isSchk() {
        return schk;
    }

    public void setSchk(boolean schk) {
        this.schk = schk;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public long getTotalResultsReturned() {
        return totalResultsReturned;
    }

    public void setTotalResultsReturned(long totalResultsReturned) {
        this.totalResultsReturned = totalResultsReturned;
    }

    public long getTotalResultsAvailable() {
        return totalResultsAvailable;
    }

    public void setTotalResultsAvailable(long totalResultsAvailable) {
        this.totalResultsAvailable = totalResultsAvailable;
    }

    public Offer[] getOffers() {
        return offers;
    }

    public void setOffers(Offer[] offers) {
        this.offers = offers;
    }

    public long getTotalLooseOffers() {
        return totalLooseOffers;
    }

    public void setTotalLooseOffers(long totalLooseOffers) {
        this.totalLooseOffers = totalLooseOffers;
    }

    public int getTotalResultsSellers() {
        return totalResultsSellers;
    }

    public void setTotalResultsSellers(int totalResultsSellers) {
        this.totalResultsSellers = totalResultsSellers;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }


    public String getThumbnailUrl() {

        String result = "";

        if (products != null && products.length > 0) {

            result = products[0].getThumbnail().getUrl();

        }

        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result = (Result) o;

        if (isSchk() != result.isSchk()) return false;
        if (getTotalResultsReturned() != result.getTotalResultsReturned()) return false;
        if (getTotalResultsAvailable() != result.getTotalResultsAvailable()) return false;
        if (getTotalLooseOffers() != result.getTotalLooseOffers()) return false;
        if (getTotalResultsSellers() != result.getTotalResultsSellers()) return false;
        if (getTotalPages() != result.getTotalPages()) return false;
        if (getPage() != result.getPage()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getProducts(), result.getProducts())) return false;
        if (getIdpg() != null ? !getIdpg().equals(result.getIdpg()) : result.getIdpg() != null)
            return false;
        if (getMatch() != null ? !getMatch().equals(result.getMatch()) : result.getMatch() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getOffers(), result.getOffers())) return false;
        if (getDetails() != null ? !getDetails().equals(result.getDetails()) : result.getDetails() != null)
            return false;
        return !(getCategory() != null ? !getCategory().equals(result.getCategory()) : result.getCategory() != null);

    }

    @Override
    public int hashCode() {
        int result = getProducts() != null ? Arrays.hashCode(getProducts()) : 0;
        result = 31 * result + (getIdpg() != null ? getIdpg().hashCode() : 0);
        result = 31 * result + (isSchk() ? 1 : 0);
        result = 31 * result + (getMatch() != null ? getMatch().hashCode() : 0);
        result = 31 * result + (int) (getTotalResultsReturned() ^ (getTotalResultsReturned() >>> 32));
        result = 31 * result + (int) (getTotalResultsAvailable() ^ (getTotalResultsAvailable() >>> 32));
        result = 31 * result + (getOffers() != null ? Arrays.hashCode(getOffers()) : 0);
        result = 31 * result + (int) (getTotalLooseOffers() ^ (getTotalLooseOffers() >>> 32));
        result = 31 * result + getTotalResultsSellers();
        result = 31 * result + (getDetails() != null ? getDetails().hashCode() : 0);
        result = 31 * result + (int) (getTotalPages() ^ (getTotalPages() >>> 32));
        result = 31 * result + (int) (getPage() ^ (getPage() >>> 32));
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "products=" + Arrays.toString(products) +
                ", idpg='" + idpg + '\'' +
                ", schk=" + schk +
                ", match='" + match + '\'' +
                ", totalResultsReturned=" + totalResultsReturned +
                ", totalResultsAvailable=" + totalResultsAvailable +
                ", offers=" + Arrays.toString(offers) +
                ", totalLooseOffers=" + totalLooseOffers +
                ", totalResultsSellers=" + totalResultsSellers +
                ", details=" + details +
                ", totalPages=" + totalPages +
                ", page=" + page +
                ", category=" + category +
                '}';
    }
}
