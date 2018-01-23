package Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mohamed on 19/01/2018.
 */

public class Utils {
    public static final String Base_URL="http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String Icon_URL="http://api.openweathermap.org/img/w/" ;

    public static JSONObject getobject(String tagname, JSONObject jsonObject ) throws JSONException {
        JSONObject jobj = jsonObject.getJSONObject(tagname);
        return jobj;
    }
    public static String getstring(String tagname, JSONObject jsonObject ) throws JSONException{

        return jsonObject.getString(tagname);


    }
    public static Float getfloat(String tagname, JSONObject jsonObject ) throws JSONException{

        return (float)jsonObject.getDouble(tagname);


    }
    public static Double getdouble(String tagname, JSONObject jsonObject ) throws JSONException{

        return jsonObject.getDouble(tagname);


    }
    public static int getint (String tagname, JSONObject jsonObject ) throws JSONException{

        return jsonObject.getInt(tagname);


    }
}
