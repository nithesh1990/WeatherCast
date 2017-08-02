package napps.weathercast.Network;

import io.reactivex.Observable;
import napps.weathercast.Model.Weather;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public interface WeatherAPIService {

   @GET("api/{apiKey}/forecast10day/q/{zipCode}/.json")
   Observable<Weather> getWeatherData(@Path("apiKey") String apiKey, @Path("zipCode") String zipCode);
}
