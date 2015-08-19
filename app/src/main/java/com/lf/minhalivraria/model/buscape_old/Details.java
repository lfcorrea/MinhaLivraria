package com.lf.minhalivraria.model.buscape_old;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/1/15.
 */
public class Details implements JSONObjectConverter {

    private String applicationID;
    private String applicationVersion;
    private String applicationPath;
    private Date date;
    private long elapsedTime;
    private String status;
    private long code;
    private String message;


    public Details() {
    }

    public Details(String applicationID, String applicationVersion, String applicationPath, Date date, long elapsedTime, String status, long code, String message) {
        this.applicationID = applicationID;
        this.applicationVersion = applicationVersion;
        this.applicationPath = applicationPath;
        this.date = date;
        this.elapsedTime = elapsedTime;
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public Details(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        String _applicationID = Util.getString(jsonObject, "applicationid");
        setApplicationID(_applicationID);

        String _applicationVersion = Util.getString(jsonObject, "applicationversion");
        setApplicationVersion(_applicationVersion);

        String _applicationPath = Util.getString(jsonObject, "applicationpath");
        setApplicationPath(_applicationPath);

        Date _date = new Date(Util.getJSONObject(jsonObject, "date"));
        setDate(_date);

        long _elapsedTime = Util.getLong(jsonObject, "elapsedtime");
        setElapsedTime(_elapsedTime);

        String _status = Util.getString(jsonObject, "status");
        setStatus(_status);

        long _code = Util.getLong(jsonObject, "code");
        setCode(_code);

        String _message = Util.getString(jsonObject, "message");
        setMessage(_message);

    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Details)) return false;

        Details details = (Details) o;

        if (getElapsedTime() != details.getElapsedTime()) return false;
        if (getCode() != details.getCode()) return false;
        if (getApplicationID() != null ? !getApplicationID().equals(details.getApplicationID()) : details.getApplicationID() != null)
            return false;
        if (getApplicationVersion() != null ? !getApplicationVersion().equals(details.getApplicationVersion()) : details.getApplicationVersion() != null)
            return false;
        if (getApplicationPath() != null ? !getApplicationPath().equals(details.getApplicationPath()) : details.getApplicationPath() != null)
            return false;
        if (getDate() != null ? !getDate().equals(details.getDate()) : details.getDate() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(details.getStatus()) : details.getStatus() != null)
            return false;
        return !(getMessage() != null ? !getMessage().equals(details.getMessage()) : details.getMessage() != null);

    }

    @Override
    public int hashCode() {
        int result = getApplicationID() != null ? getApplicationID().hashCode() : 0;
        result = 31 * result + (getApplicationVersion() != null ? getApplicationVersion().hashCode() : 0);
        result = 31 * result + (getApplicationPath() != null ? getApplicationPath().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (int) (getElapsedTime() ^ (getElapsedTime() >>> 32));
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (int) (getCode() ^ (getCode() >>> 32));
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Details{" +
                "applicationID='" + applicationID + '\'' +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", applicationPath='" + applicationPath + '\'' +
                ", date=" + date +
                ", elapsedTime=" + elapsedTime +
                ", status='" + status + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
