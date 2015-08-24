package com.lf.minhalivraria.model.buscape;

import java.io.Serializable;

public class Date implements Serializable {
    private int minute;

    private boolean valid;

    private int timezone;

    private int second;

    private long millisecond;

    private int month;

    private int year;

    private int day;

    private int hour;

    private Xmlschematype xmlschematype;

    private Eonandyear eonandyear;

    public Date() {
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public long getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(long millisecond) {
        this.millisecond = millisecond;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Xmlschematype getXmlschematype() {
        return xmlschematype;
    }

    public void setXmlschematype(Xmlschematype xmlschematype) {
        this.xmlschematype = xmlschematype;
    }

    public Eonandyear getEonandyear() {
        return eonandyear;
    }

    public void setEonandyear(Eonandyear eonandyear) {
        this.eonandyear = eonandyear;
    }

    @Override
    public String toString() {
        return "Date{" +
                "minute='" + minute + '\'' +
                ", valid='" + valid + '\'' +
                ", timezone='" + timezone + '\'' +
                ", second='" + second + '\'' +
                ", millisecond='" + millisecond + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", xmlschematype=" + xmlschematype +
                ", eonandyear=" + eonandyear +
                '}';
    }
}
