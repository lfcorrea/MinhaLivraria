package com.lf.minhalivraria.model;

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
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

    public VolumeInfo() {
    }

    public VolumeInfo(String title, String[] authors, String publishedDate, IndustryIdentifier[] industryIdentifiers, ReadingMode readingModes, String printType, String[] categories, String maturityRating, boolean allowAnonLogging, String contentVersion, String language, String previewLink, String infoLink, String canonicalVolumeLink) {
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
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
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
