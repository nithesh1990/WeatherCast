package napps.weathercast.Contract.ViewPresenter;

import java.util.List;

import napps.weathercast.Model.ForeCastDayDetail;
import napps.weathercast.Model.Forecastday;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public interface ForeCastViewContract {

    interface View {

        void showForeCastError();

        void showForeCastList(List<Forecastday> foreCastList);

        String getZipCode();

        void showZipCodeError();

        void showDetailForeCast(ForeCastDayDetail foreCastDayDetail);
    }

    interface Presenter {
        void getWeatherForeCast();
        void getDetailForeCast(int dayNumber);
    }
}
