package napps.weathercast.Model;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class Weather {

    private long timeStamp;

    private String zipcode;

    private Response response;

    public Response getResponse() { return this.response; }

    public void setResponse(Response response) { this.response = response; }

    private Forecast forecast;

    public Forecast getForecast() { return this.forecast; }

    public void setForecast(Forecast forecast) { this.forecast = forecast; }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
