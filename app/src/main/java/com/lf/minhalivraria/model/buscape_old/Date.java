package com.lf.minhalivraria.model.buscape_old;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luizfernando on 8/2/15.
 */
public class Date implements JSONObjectConverter {

    private boolean valid;
    private long eonAndYearLowestSetBit;
    private int month;
    private int hour;
    private int year;
    private int timezone;
    private long millisecond;
    private XmlSchemaType xmlSchemaType;
    private int day;
    private int minute;
    private int second;

    public Date() {
    }

    public Date(boolean valid, long eonAndYearLowestSetBit, int month, int hour, int year, int timezone, long millisecond, XmlSchemaType xmlSchemaType, int day, int minute, int second) {
        this.valid = valid;
        this.eonAndYearLowestSetBit = eonAndYearLowestSetBit;
        this.month = month;
        this.hour = hour;
        this.year = year;
        this.timezone = timezone;
        this.millisecond = millisecond;
        this.xmlSchemaType = xmlSchemaType;
        this.day = day;
        this.minute = minute;
        this.second = second;
    }

    public Date(JSONObject jsonObject) throws JSONException {
        this.fromJSON(jsonObject);
    }

    @Override
    public void toJSON() {

    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {

        boolean _valid = jsonObject.getBoolean("valid");
        setValid(_valid);

        long _eonAndYearLowestSetBit = jsonObject.getJSONObject("eonandyear").getLong("lowestsetbit");
        setEonAndYearLowestSetBit(_eonAndYearLowestSetBit);

        int _month = jsonObject.getInt("month");
        setMonth(_month);

        int _hour = jsonObject.getInt("hour");
        setHour(_hour);

        int _year = jsonObject.getInt("year");
        setYear(_year);

        int _timezone = jsonObject.getInt("timezone");
        setTimezone(_timezone);

        long _millisecond = jsonObject.getLong("millisecond");
        setMillisecond(_millisecond);

        XmlSchemaType _xmlSchemaType = new XmlSchemaType(jsonObject.getJSONObject("xmlschematype"));
        setXmlSchemaType(_xmlSchemaType);

        int _day = jsonObject.getInt("day");
        setDay(_day);

        int _minute = jsonObject.getInt("minute");
        setMinute(_minute);

        int _second = jsonObject.getInt("second");
        setSecond(_second);

    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public long getEonAndYearLowestSetBit() {
        return eonAndYearLowestSetBit;
    }

    public void setEonAndYearLowestSetBit(long eonAndYearLowestSetBit) {
        this.eonAndYearLowestSetBit = eonAndYearLowestSetBit;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public long getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(long millisecond) {
        this.millisecond = millisecond;
    }

    public XmlSchemaType getXmlSchemaType() {
        return xmlSchemaType;
    }

    public void setXmlSchemaType(XmlSchemaType xmlSchemaType) {
        this.xmlSchemaType = xmlSchemaType;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date date = (Date) o;

        if (isValid() != date.isValid()) return false;
        if (getEonAndYearLowestSetBit() != date.getEonAndYearLowestSetBit()) return false;
        if (getMonth() != date.getMonth()) return false;
        if (getHour() != date.getHour()) return false;
        if (getYear() != date.getYear()) return false;
        if (getTimezone() != date.getTimezone()) return false;
        if (getMillisecond() != date.getMillisecond()) return false;
        if (getDay() != date.getDay()) return false;
        if (getMinute() != date.getMinute()) return false;
        if (getSecond() != date.getSecond()) return false;
        return !(getXmlSchemaType() != null ? !getXmlSchemaType().equals(date.getXmlSchemaType()) : date.getXmlSchemaType() != null);

    }

    @Override
    public int hashCode() {
        int result = (isValid() ? 1 : 0);
        result = 31 * result + (int) (getEonAndYearLowestSetBit() ^ (getEonAndYearLowestSetBit() >>> 32));
        result = 31 * result + getMonth();
        result = 31 * result + getHour();
        result = 31 * result + getYear();
        result = 31 * result + getTimezone();
        result = 31 * result + (int) (getMillisecond() ^ (getMillisecond() >>> 32));
        result = 31 * result + (getXmlSchemaType() != null ? getXmlSchemaType().hashCode() : 0);
        result = 31 * result + getDay();
        result = 31 * result + getMinute();
        result = 31 * result + getSecond();
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "valid=" + valid +
                ", eonAndYearLowestSetBit=" + eonAndYearLowestSetBit +
                ", month=" + month +
                ", hour=" + hour +
                ", year=" + year +
                ", timezone=" + timezone +
                ", millisecond=" + millisecond +
                ", xmlSchemaType=" + xmlSchemaType +
                ", day=" + day +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
