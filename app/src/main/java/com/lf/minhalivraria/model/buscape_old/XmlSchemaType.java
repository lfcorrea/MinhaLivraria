package com.lf.minhalivraria.model.buscape_old;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/2/15.
 */
public class XmlSchemaType implements JSONObjectConverter {

    private String prefix;
    private String localPart;
    private String namespaceUri;

    public XmlSchemaType() {
    }

    public XmlSchemaType(String prefix, String localPart, String namespaceUri) {
        this.prefix = prefix;
        this.localPart = localPart;
        this.namespaceUri = namespaceUri;
    }

    public XmlSchemaType(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        String _prefix = Util.getString(jsonObject, "prefix");
        setPrefix(_prefix);

        String _localPart = Util.getString(jsonObject, "localpart");
        setLocalPart(_localPart);

        String _namespaceUri = Util.getString(jsonObject, "namespaceuri");
        setNamespaceUri(_namespaceUri);

    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLocalPart() {
        return localPart;
    }

    public void setLocalPart(String localPart) {
        this.localPart = localPart;
    }

    public String getNamespaceUri() {
        return namespaceUri;
    }

    public void setNamespaceUri(String namespaceUri) {
        this.namespaceUri = namespaceUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XmlSchemaType)) return false;

        XmlSchemaType that = (XmlSchemaType) o;

        if (getPrefix() != null ? !getPrefix().equals(that.getPrefix()) : that.getPrefix() != null)
            return false;
        if (getLocalPart() != null ? !getLocalPart().equals(that.getLocalPart()) : that.getLocalPart() != null)
            return false;
        return !(getNamespaceUri() != null ? !getNamespaceUri().equals(that.getNamespaceUri()) : that.getNamespaceUri() != null);

    }

    @Override
    public int hashCode() {
        int result = getPrefix() != null ? getPrefix().hashCode() : 0;
        result = 31 * result + (getLocalPart() != null ? getLocalPart().hashCode() : 0);
        result = 31 * result + (getNamespaceUri() != null ? getNamespaceUri().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "XmlSchemaType{" +
                "prefix='" + prefix + '\'' +
                ", localPart='" + localPart + '\'' +
                ", namespaceUri='" + namespaceUri + '\'' +
                '}';
    }
}
