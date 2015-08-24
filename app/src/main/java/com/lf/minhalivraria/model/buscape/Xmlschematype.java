package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Xmlschematype implements Serializable {
    private String namespaceuri;

    private String prefix;

    private String localpart;

    public Xmlschematype() {
    }

    public String getNamespaceuri() {
        return namespaceuri;
    }

    public void setNamespaceuri(String namespaceuri) {
        this.namespaceuri = namespaceuri;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLocalpart() {
        return localpart;
    }

    public void setLocalpart(String localpart) {
        this.localpart = localpart;
    }

    @Override
    public String toString() {
        return "Xmlschematype{" +
                "namespaceuri='" + namespaceuri + '\'' +
                ", prefix='" + prefix + '\'' +
                ", localpart='" + localpart + '\'' +
                '}';
    }
}
