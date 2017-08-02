package napps.weathercast;

import android.app.Application;

import napps.weathercast.Data.DaggerWeatherDataRepositoryComponent;
import napps.weathercast.Data.WeatherDataRepositoryComponent;
import napps.weathercast.Network.WeatherAPIModule;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class WeatherApplication extends Application {

    WeatherDataRepositoryComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerWeatherDataRepositoryComponent.builder().weatherAPIModule(new WeatherAPIModule()).build();
    }

    public WeatherDataRepositoryComponent getWeatherDataComponent(){
        return mComponent;
    }
}
