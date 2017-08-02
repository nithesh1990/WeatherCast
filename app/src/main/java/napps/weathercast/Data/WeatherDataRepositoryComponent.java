package napps.weathercast.Data;

import javax.inject.Singleton;

import dagger.Component;
import napps.weathercast.Network.WeatherAPIModule;

/**
 * Created by "nithesh" on 8/1/2017.
 */
@Singleton
@Component(modules = WeatherAPIModule.class)
public interface WeatherDataRepositoryComponent {

    WeatherDataRepository getWeatherDataRepository();
}
