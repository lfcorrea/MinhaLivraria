package com.lf.minhalivraria.model.buscape_old;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Category implements JSONObjectConverter {

    private boolean concatenateCategoryName;
    private String thumbnailUrl;
    private boolean hasOffer;
    private long parentCategoryId;
    private boolean isFinal;
    private String name;
    private Link[] links;
    private long id;

    public Category() {
    }

    public Category(boolean concatenateCategoryName, String thumbnailUrl, boolean hasOffer, long parentCategoryId, boolean isFinal, String name, Link[] links, long id) {
        this.concatenateCategoryName = concatenateCategoryName;
        this.thumbnailUrl = thumbnailUrl;
        this.hasOffer = hasOffer;
        this.parentCategoryId = parentCategoryId;
        this.isFinal = isFinal;
        this.name = name;
        this.links = links;
        this.id = id;
    }

    public Category(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        boolean _concatenateCategoryName = Util.getBoolean(jsonObject, "concatenatecategoryname");
        setConcatenateCategoryName(_concatenateCategoryName);

        String _thumbnailUrl = Util.getString(Util.getJSONObject(jsonObject, "thumbnail"), "url");
        setThumbnailUrl(_thumbnailUrl);

        boolean _hasOffer = Util.getBoolean(jsonObject, "hasoffer");
        setHasOffer(_hasOffer);

        long _parentCategoryId = Util.getLong(jsonObject, "parentcategoryid");
        setParentCategoryId(_parentCategoryId);

        boolean _isFinal = Util.getBoolean(jsonObject, "isfinal");
        setIsFinal(_isFinal);

        String _name = Util.getString(jsonObject, "name");
        setName(_name);

        setLinks(Util.getLinks(jsonObject));

        long _id = Util.getLong(jsonObject, "id");
        setId(_id);

    }

    public boolean isConcatenateCategoryName() {
        return concatenateCategoryName;
    }

    public void setConcatenateCategoryName(boolean concatenateCategoryName) {
        this.concatenateCategoryName = concatenateCategoryName;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public boolean isHasOffer() {
        return hasOffer;
    }

    public void setHasOffer(boolean hasOffer) {
        this.hasOffer = hasOffer;
    }

    public long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (isConcatenateCategoryName() != category.isConcatenateCategoryName()) return false;
        if (isHasOffer() != category.isHasOffer()) return false;
        if (getParentCategoryId() != category.getParentCategoryId()) return false;
        if (isFinal() != category.isFinal()) return false;
        if (getId() != category.getId()) return false;
        if (getThumbnailUrl() != null ? !getThumbnailUrl().equals(category.getThumbnailUrl()) : category.getThumbnailUrl() != null)
            return false;
        if (getName() != null ? !getName().equals(category.getName()) : category.getName() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getLinks(), category.getLinks());

    }

    @Override
    public int hashCode() {
        int result = (isConcatenateCategoryName() ? 1 : 0);
        result = 31 * result + (getThumbnailUrl() != null ? getThumbnailUrl().hashCode() : 0);
        result = 31 * result + (isHasOffer() ? 1 : 0);
        result = 31 * result + (int) (getParentCategoryId() ^ (getParentCategoryId() >>> 32));
        result = 31 * result + (isFinal() ? 1 : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLinks() != null ? Arrays.hashCode(getLinks()) : 0);
        result = 31 * result + (int) (getId() ^ (getId() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "concatenateCategoryName=" + concatenateCategoryName +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", hasOffer=" + hasOffer +
                ", parentCategoryId=" + parentCategoryId +
                ", isFinal=" + isFinal +
                ", name='" + name + '\'' +
                ", links=" + Arrays.toString(links) +
                ", id=" + id +
                '}';
    }
}
