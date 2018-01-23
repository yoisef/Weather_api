package data;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;
import youssef.com.myweather.MainActivity;

/**
 * Created by mohamed on 20/01/2018.
 */

public class WeatherHttpClient {
    Context context;

    public String getsweatherData(String place)
    {
        HttpURLConnection connection=null;
        InputStream inputStream=null;


        try {
            connection=(HttpURLConnection)(new URL(Utils.Base_URL+place)).openConnection();
            connection.setRequestProperty("x-api-key","27cf2d5cfb5bd73db0ffdfe24b5330f1");
            connection.setRequestMethod("GET");

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            //read the response
            StringBuffer stringBuffer=new StringBuffer();
            inputStream=connection.getInputStream();//البيانات في شكل bytes
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));//اوبجكت لقراءة البيانات من الويب التي في شكل bytes
            String line=null;
            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(line+"\r\n");
            }
            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();
        } catch (IOException e) {
            connection.disconnect();
            e.printStackTrace();
        }
        return  null;
    }
}
