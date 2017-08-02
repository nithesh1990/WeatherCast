package napps.weathercast.Contract.ModelView;

import java.util.List;

import napps.weathercast.Model.ForeCastDayDetail;
import napps.weathercast.Model.Forecastday;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public interface WeatherDataSource {

    interface WeatherForeCastReceiver extends DataReceiver {

        void OnForeCastReceived(List<Forecastday> forecastDayList);
    }

    interface DetailForeCastReceiver extends DataReceiver {

        void OnDetailFOreCastReceived(ForeCastDayDetail detailForeCast);
    }

    void getWeatherForeCast(WeatherForeCastReceiver weatherForeCastReceiver, String zipCode);

    void getDetailForeCastforDay(DetailForeCastReceiver detailForeCastReceiver, int dayNumber);
}
