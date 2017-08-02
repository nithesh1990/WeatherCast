package napps.weathercast.Model;

import java.util.List;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class TxtForecast {
    private String date;

    public String getDate() { return this.date; }

    public void setDate(String date) { this.date = date; }

    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() { return this.forecastday; }

    public void setForecastday(List<Forecastday> forecastday) { this.forecastday = forecastday; }
}
