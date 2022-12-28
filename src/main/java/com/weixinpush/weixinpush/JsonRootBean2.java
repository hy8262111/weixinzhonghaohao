package com.weixinpush.weixinpush;

import java.util.Date;
import java.util.List;

public class JsonRootBean2 {

    private int status;
    private Result result;
    private String message;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}

class Location {

    private String country;
    private String province;
    private String city;
    private String name;
    private String id;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}

class Now {

    private String text;
    private int temp;
    private int feels_like;
    private int rh;
    private String wind_class;
    private String wind_dir;
    private String uptime;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public void setFeels_like(int feels_like) {
        this.feels_like = feels_like;
    }

    public int getFeels_like() {
        return feels_like;
    }

    public void setRh(int rh) {
        this.rh = rh;
    }

    public int getRh() {
        return rh;
    }

    public void setWind_class(String wind_class) {
        this.wind_class = wind_class;
    }

    public String getWind_class() {
        return wind_class;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getUptime() {
        return uptime;
    }

}

class Forecasts {

    private String text_day;
    private String text_night;
    private int high;
    private int low;
    private String wc_day;
    private String wd_day;
    private String wc_night;
    private String wd_night;
    private Date date;
    private String week;

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public String getText_day() {
        return text_day;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }

    public String getText_night() {
        return text_night;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getLow() {
        return low;
    }

    public void setWc_day(String wc_day) {
        this.wc_day = wc_day;
    }

    public String getWc_day() {
        return wc_day;
    }

    public void setWd_day(String wd_day) {
        this.wd_day = wd_day;
    }

    public String getWd_day() {
        return wd_day;
    }

    public void setWc_night(String wc_night) {
        this.wc_night = wc_night;
    }

    public String getWc_night() {
        return wc_night;
    }

    public void setWd_night(String wd_night) {
        this.wd_night = wd_night;
    }

    public String getWd_night() {
        return wd_night;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeek() {
        return week;
    }

}

class Result {

    private Location location;
    private Now now;
    private List<Forecasts> forecasts;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public Now getNow() {
        return now;
    }

    public void setForecasts(List<Forecasts> forecasts) {
        this.forecasts = forecasts;
    }

    public List<Forecasts> getForecasts() {
        return forecasts;
    }

}
