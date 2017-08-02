package napps.weathercast.Model;

import java.util.List;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class SimpleForecast {
    private List<ForeCastDayDetail> forecastday;

    public List<ForeCastDayDetail> getForecastday() { return this.forecastday; }

    public void setForecastday(List<ForeCastDayDetail> forecastday) { this.forecastday = forecastday; }
}
