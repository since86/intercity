package com.welvx.intercity.entity;

import java.io.Serializable;

public class Geom implements Serializable {
    private static final long serialVersionUID = -1572063517919285101L;
    private String city;
    private String addr;
    private double lat;
    private double lon;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
