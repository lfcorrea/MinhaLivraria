package com.lf.minhalivraria.model.buscape;

public class Details {
    private String message;

    private String status;

    private long elapsedtime;

    private long code;

    private String applicationversion;

    private Date date;

    private String applicationid;

    private String applicationpath;

    public Details() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getElapsedtime() {
        return elapsedtime;
    }

    public void setElapsedtime(long elapsedtime) {
        this.elapsedtime = elapsedtime;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getApplicationversion() {
        return applicationversion;
    }

    public void setApplicationversion(String applicationversion) {
        this.applicationversion = applicationversion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public String getApplicationpath() {
        return applicationpath;
    }

    public void setApplicationpath(String applicationpath) {
        this.applicationpath = applicationpath;
    }

    @Override
    public String toString() {
        return "Details{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", elapsedtime='" + elapsedtime + '\'' +
                ", code='" + code + '\'' +
                ", applicationversion='" + applicationversion + '\'' +
                ", date=" + date +
                ", applicationid='" + applicationid + '\'' +
                ", applicationpath='" + applicationpath + '\'' +
                '}';
    }
}
