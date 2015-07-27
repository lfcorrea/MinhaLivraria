package com.lf.minhalivraria.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 7/13/15.
 */
public class VolumeInfo {

    private String title;
    private String[] authors;
    private String publishedDate;
    private IndustryIdentifier[] industryIdentifiers;
    private ReadingMode readingModes;
    private String printType;
    private String[] categories;
    private String maturityRating;
    private boolean allowAnonLogging;
    private String contentVersion;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

    public VolumeInfo() {
    }

    public VolumeInfo(String title, String[] authors, String publishedDate, IndustryIdentifier[] industryIdentifiers, ReadingMode readingModes, String printType, String[] categories, String maturityRating, boolean allowAnonLogging, String contentVersion, ImageLinks imageLinks, String language, String previewLink, String infoLink, String canonicalVolumeLink) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.industryIdentifiers = industryIdentifiers;
        this.readingModes = readingModes;
        this.printType = printType;
        this.categories = categories;
        this.maturityRating = maturityRating;
        this.allowAnonLogging = allowAnonLogging;
        this.contentVersion = contentVersion;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public void loadFromJSON(JSONObject jsonObject) throws JSONException {

        String _title = jsonObject.getString("title");
        setTitle(_title);

        JSONArray _authorsArrayObject = jsonObject.getJSONArray("authors");
        int numberOfAuthors = _authorsArrayObject.length();
        String[] _authors = new String[numberOfAuthors];
        for (int i = 0; i < numberOfAuthors; i++) {
            _authors[i] = _authorsArrayObject.get(i).toString();
        }
        setAuthors(_authors);

        String _publishedDate = jsonObject.getString("publishedDate");
        setPublishedDate(_publishedDate);

        JSONArray _industryIdentifiersArrayObject = jsonObject.getJSONArray("industryIdentifiers");
        int numberOfIndustryIdentifiers = _industryIdentifiersArrayObject.length();
        IndustryIdentifier[] _industryIdentifiers = new IndustryIdentifier[numberOfIndustryIdentifiers];
        for (int i = 0; i < numberOfIndustryIdentifiers; i++) {
            JSONObject _industryIdentifierObject = _industryIdentifiersArrayObject.getJSONObject(i);

            IndustryIdentifier industryIdentifier = new IndustryIdentifier();
            industryIdentifier.loadFromJSON(_industryIdentifierObject);
            _industryIdentifiers[i] = industryIdentifier;

        }
        setIndustryIdentifiers(_industryIdentifiers);

        JSONObject _readingModesObject = jsonObject.getJSONObject("readingModes");
        ReadingMode _readingModes = new ReadingMode();
        _readingModes.loadFromJSON(_readingModesObject);
        setReadingModes(_readingModes);

        String _printType = jsonObject.getString("printType");
        setPrintType(_printType);

        JSONArray _categoriesArrayObject = jsonObject.getJSONArray("categories");
        int sizeCategories = _categoriesArrayObject.length();
        String[] _categories = new String[sizeCategories];
        for (int i = 0; i < sizeCategories; i++) {
            _categories[i] = _categoriesArrayObject.get(i).toString();
        }
        setCategories(_categories);

        String _matureRating = jsonObject.getString("maturityRating");
        setMaturityRating(_matureRating);

        Boolean _allowAnonLogging = jsonObject.getBoolean("allowAnonLogging");
        setAllowAnonLogging(_allowAnonLogging);

        String _contentVersion = jsonObject.getString("contentVersion");
        setContentVersion(_contentVersion);

        if (jsonObject.has("imageLinks")) {
            JSONObject _imageLinksObject = jsonObject.getJSONObject("imageLinks");
            ImageLinks _imageLinks = new ImageLinks();
            _imageLinks.loadFromJSON(_imageLinksObject);

            setImageLinks(_imageLinks);
        }

        String _language = jsonObject.getString("language");
        setLanguage(_language);

        String _previewLink = jsonObject.getString("previewLink");
        setPreviewLink(_previewLink);

        String _infoLink = jsonObject.getString("infoLink");
        setInfoLink(_infoLink);

        String _canonicalVolumeLink = jsonObject.getString("canonicalVolumeLink");
        setCanonicalVolumeLink(_canonicalVolumeLink);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public IndustryIdentifier[] getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(IndustryIdentifier[] industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public ReadingMode getReadingModes() {
        return readingModes;
    }

    public void setReadingModes(ReadingMode readingModes) {
        this.readingModes = readingModes;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public boolean isAllowAnonLogging() {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging(boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }
}
