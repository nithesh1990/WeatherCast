package napps.weathercast.Model;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class Forecast {
    private TxtForecast txt_forecast;

    public TxtForecast getTxtForecast() { return this.txt_forecast; }

    public void setTxtForecast(TxtForecast txt_forecast) { this.txt_forecast = txt_forecast; }

    private SimpleForecast simpleforecast;

    public SimpleForecast getSimpleforecast() { return this.simpleforecast; }

    public void setSimpleforecast(SimpleForecast simpleforecast) { this.simpleforecast = simpleforecast; }
}
