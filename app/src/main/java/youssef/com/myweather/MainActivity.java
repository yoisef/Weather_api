package youssef.com.myweather;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.util.Date;

import data.JSonWeatherParsing;
import data.WeatherHttpClient;
import model.Place;
import model.Weather;

public class MainActivity extends AppCompatActivity {
    private TextView cityy;
    private TextView tempp;
    private TextView cloudd;
    private TextView presuree;
    private TextView humdityy;
    private TextView sunrise;
    private TextView sunsett;
    private TextView updatee;
    private ImageView thumbnaill;
    private TextView condition;


    Weather weather=new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityy = (TextView) findViewById(R.id.citytext);
        tempp = (TextView) findViewById(R.id.temptext);
        cloudd = (TextView) findViewById(R.id.cloudtext);
        presuree = (TextView) findViewById(R.id.pressuretext);
        humdityy = (TextView) findViewById(R.id.humidtytext);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunsett = (TextView) findViewById(R.id.sunset);
        thumbnaill = (ImageView) findViewById(R.id.thumbnailicon);
        condition=(TextView)findViewById(R.id.condition) ;

        renderWeatherData("Moscow,RU");


    }

    public void renderWeatherData(String city)
    {
       WeatherTask weatherTask=new WeatherTask();
        weatherTask.execute(new String[]{city + "&units=metric"});
    }



    private class downloadimageAsyntask extends AsyncTask<String,void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }
        private Bitmap downloadimg(String code)
        {

           return
        }
    }




    private class WeatherTask extends AsyncTask<String,Void, Weather>
    {

        @Override
        protected Weather doInBackground(String... strings) {
            String data=( (new WeatherHttpClient()).getsweatherData(strings[0]));
            weather=JSonWeatherParsing.getweather(data);
             Log.v("Data" , String.valueOf(weather.currentCondation.getHumidity()));
            return weather;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            DateFormat df=DateFormat.getTimeInstance();
            String sunset=df.format(new Date(weather.place.getSunsrt()));
            String sunrisee=df.format(new Date(weather.place.getSunrise()));
            cityy.setText(weather.place.getCity()+" , "+weather.place.getCountry());
            tempp.setText(" "+ weather.currentCondation.getTempertaure()+" C");
            humdityy.setText("Humidity:"+weather.currentCondation.getHumidity());
            presuree.setText("Pressure :"+weather.currentCondation.getPressure());
            sunsett.setText("Sunset :"+sunset);
            sunrise.setText("SunRise:"+sunrisee);
            condition.setText("Condition :"+weather.currentCondation.getDescription()+"("+weather.currentCondation.getCondition()+")");



        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}