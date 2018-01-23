package model;

/**
 * Created by mohamed on 19/01/2018.
 */

public class CurrentCondation {
    private int weatherid;
    private String condition;
    private String description;
    private String icon;
    private Float pressure;
    private Float humidity;
    private Float maxtemp;
    private Float mintemp;
    private double tempertaure;

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getWeatherid() {
        return weatherid;
    }

    public void setWeatherid(int weatherid) {
        this.weatherid = weatherid;
    }

    public Float getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(Float maxtemp) {
        this.maxtemp = maxtemp;
    }

    public Float getMintemp() {
        return mintemp;
    }

    public void setMintemp(Float mintemp) {
        this.mintemp = mintemp;
    }

    public double getTempertaure() {
        return tempertaure;
    }

    public void setTempertaure(double tempertaure) {
        this.tempertaure = tempertaure;
    }
}
