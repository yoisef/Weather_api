package model;

/**
 * Created by mohamed on 19/01/2018.
 */

public class Place {

    private float lon;
    private float lat;
    private long sunsrt;
    private long sunrise;
    private String country;
    private String city;
    private long update;
    private int id;

    public long getUpdate() {
        return update;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunsrt() {
        return sunsrt;
    }

    public void setSunsrt(long sunsrt) {
        this.sunsrt = sunsrt;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
