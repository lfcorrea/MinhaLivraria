package com.lf.minhalivraria.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 7/13/15.
 */
public class AccessInfo {

    private String country;
    private String viewability;
    private boolean embeddable;
    private boolean publicDomain;
    private String textToSpeechPermission;
    private boolean epub_isAvailable;
    private boolean pdf_isAvailable;
    private String webReaderLink;
    private String accessViewStatus;
    private boolean quoteSharingAllowed;


    public AccessInfo() {
    }

    public AccessInfo(String country, String viewability, boolean embeddable, boolean publicDomain, String textToSpeechPermission, boolean epub_isAvailable, boolean pdf_isAvailable, String webReaderLink, String accessViewStatus, boolean quoteSharingAllowed) {
        this.country = country;
        this.viewability = viewability;
        this.embeddable = embeddable;
        this.publicDomain = publicDomain;
        this.textToSpeechPermission = textToSpeechPermission;
        this.epub_isAvailable = epub_isAvailable;
        this.pdf_isAvailable = pdf_isAvailable;
        this.webReaderLink = webReaderLink;
        this.accessViewStatus = accessViewStatus;
        this.quoteSharingAllowed = quoteSharingAllowed;
    }

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        String _country = jsonObject.getString("country");
        setCountry(_country);

        String _viewability = jsonObject.getString("viewability");
        setViewability(_viewability);

        boolean _embeddable = jsonObject.getBoolean("embeddable");
        setEmbeddable(_embeddable);

        boolean _publicDomain = jsonObject.getBoolean("publicDomain");
        setPublicDomain(_publicDomain);

        String _textToSpeechPermission = jsonObject.getString("textToSpeechPermission");
        setTextToSpeechPermission(_textToSpeechPermission);

        boolean _epub_isAvailable = jsonObject.getJSONObject("epub").getBoolean("isAvailable");
        setEpub_isAvailable(_epub_isAvailable);

        boolean _pdf_isAvailable = jsonObject.getJSONObject("pdf").getBoolean("isAvailable");
        setPdf_isAvailable(_pdf_isAvailable);

        String _webReaderLink = jsonObject.getString("webReaderLink");
        setWebReaderLink(_webReaderLink);

        String _accessViewStatus = jsonObject.getString("accessViewStatus");
        setAccessViewStatus(_accessViewStatus);

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getViewability() {
        return viewability;
    }

    public void setViewability(String viewability) {
        this.viewability = viewability;
    }

    public boolean isEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(boolean embeddable) {
        this.embeddable = embeddable;
    }

    public boolean isPublicDomain() {
        return publicDomain;
    }

    public void setPublicDomain(boolean publicDomain) {
        this.publicDomain = publicDomain;
    }

    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    public void setTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
    }

    public boolean isEpub_isAvailable() {
        return epub_isAvailable;
    }

    public void setEpub_isAvailable(boolean epub_isAvailable) {
        this.epub_isAvailable = epub_isAvailable;
    }

    public boolean isPdf_isAvailable() {
        return pdf_isAvailable;
    }

    public void setPdf_isAvailable(boolean pdf_isAvailable) {
        this.pdf_isAvailable = pdf_isAvailable;
    }

    public String getWebReaderLink() {
        return webReaderLink;
    }

    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }

    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    public void setAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
    }

    public boolean isQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    public void setQuoteSharingAllowed(boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
    }
}
