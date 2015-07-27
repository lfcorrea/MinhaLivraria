package com.lf.minhalivraria.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 7/13/15.
 */
public class Item {

    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;
    private SaleInfo saleInfo;
    private AccessInfo accessInfo;

    public Item() {
    }

    public Item(String kind, String id, String etag, String selfLink, VolumeInfo volumeInfo, SaleInfo saleInfo, AccessInfo accessInfo) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
        this.saleInfo = saleInfo;
        this.accessInfo = accessInfo;
    }

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        String _kind = jsonObject.getString("kind");
        setKind(_kind);

        String _id = jsonObject.getString("id");
        setId(_id);

        String _etag = jsonObject.getString("etag");
        setEtag(_etag);

        String _selfLink = jsonObject.getString("selfLink");
        setSelfLink(_selfLink);

        JSONObject _volumeInfoObject = jsonObject.getJSONObject("volumeInfo");
        VolumeInfo _volumeInfo = new VolumeInfo();
        _volumeInfo.loadFromJSON(_volumeInfoObject);
        setVolumeInfo(_volumeInfo);

        JSONObject _saleInfoObject = jsonObject.getJSONObject("saleInfo");
        SaleInfo _saleInfo = new SaleInfo();
        _saleInfo.loadFromJSON(_saleInfoObject);
        setSaleInfo(_saleInfo);

        JSONObject _accessInfoObject = jsonObject.getJSONObject("accessInfo");
        AccessInfo _accessInfo = new AccessInfo();
        _accessInfo.loadFromJSON(_accessInfoObject);
        setAccessInfo(_accessInfo);

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }
}
