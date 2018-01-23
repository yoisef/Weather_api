package model;

/**
 * Created by mohamed on 20/01/2018.
 */

public class Weather {
    public Place place;
    public String icondata;
    public CurrentCondation currentCondation=new CurrentCondation();
    public Temperature temperature=new Temperature();
    public Wind wind=new Wind();
    public Snow snow=new Snow();
    public Clouds clouds=new Clouds();
}
