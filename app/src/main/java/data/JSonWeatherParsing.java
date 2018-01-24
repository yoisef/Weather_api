package data;

import android.media.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import Util.Utils;
import model.Clouds;
import model.CurrentCondation;
import model.Place;
import model.Weather;
import model.Wind;

/**
 * Created by mohamed on 20/01/2018.
 */

public class JSonWeatherParsing {
    public static Weather getweather(String data) {
        Weather weather = new Weather();


        //create jsonobject from data
        try {
            JSONObject jsonObject = new JSONObject(data);
            Place place = new Place();
            JSONObject Coord = Utils.getobject("coord", jsonObject);
            place.setLat(Utils.getfloat("lat", Coord));
            place.setLon(Utils.getfloat("lon", Coord));

            //get sys
            JSONObject sys = Utils.getobject("sys", jsonObject);
            place.setSunrise(Utils.getint("sunrise", sys));
            place.setCountry(Utils.getstring("country", sys));
            place.setSunsrt(Utils.getint("sunset", sys));
            place.setCity(Utils.getstring("name", jsonObject));
            place.setId(Utils.getint("id",jsonObject));
            weather.place = place;
            place.setUpdate(Utils.getint("dt", jsonObject));

            //get weather

            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonweather = jsonArray.getJSONObject(0);

            weather.currentCondation.setWeatherid(Utils.getint("id", jsonweather));
            weather.currentCondation.setDescription(Utils.getstring("description", jsonweather));
            weather.currentCondation.setCondition(Utils.getstring("main", jsonweather));
            weather.currentCondation.setIcon(Utils.getstring("icon", jsonweather));
            weather.currentCondation.setCondition(Utils.getstring("main", jsonweather));

            JSONObject main = Utils.getobject("main", jsonObject);
            weather.currentCondation.setTempertaure(Utils.getdouble("temp", main));
            weather.currentCondation.setHumidity(Utils.getfloat("humidity", main));
            weather.currentCondation.setPressure(Utils.getfloat("pressure", main));


            //get wind
            Wind wind = new Wind();
            JSONObject windobj = Utils.getobject("wind", jsonObject);
            wind.setSpeed(Utils.getfloat("speed", windobj));
            wind.setDeg(Utils.getfloat("deg", windobj));
            weather.wind = wind;
            //getcloud
            Clouds clouds = new Clouds();
            JSONObject cloudobj = Utils.getobject("clouds", jsonObject);
            clouds.setPreciptiation(Utils.getint("all", cloudobj));
            weather.clouds = clouds;
            return weather;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}


