package napps.weathercast.Data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import napps.weathercast.Contract.ModelView.WeatherDataSource;
import napps.weathercast.Model.ForeCastDayDetail;
import napps.weathercast.Model.Forecastday;
import napps.weathercast.Network.WeatherAPIModule;

/**
 * Created by "nithesh" on 8/2/2017.
 */
public class WeatherDataRepositoryTest {

    @Inject
    WeatherDataRepository weatherDataRepository;

    List<Forecastday> foreCastList;

    ForeCastDayDetail foreCastDayDetail;
    @Test
    public void getWeatherForeCast() throws Exception {

        weatherDataRepository.getWeatherForeCast(new WeatherDataSource.WeatherForeCastReceiver() {
            @Override
            public void OnForeCastReceived(List<Forecastday> forecastDayList) {
                foreCastList = forecastDayList;
            }

            @Override
            public void onError() {
                foreCastList = null;
            }
        }, "(^&**&(");

        CountDownLatch lock = new CountDownLatch(1);

        lock.await(5, TimeUnit.SECONDS);

        Assert.assertNotNull(foreCastList);
    }

    @Test
    public void getDetailForeCastforDay() throws Exception {
        weatherDataRepository.getDetailForeCastforDay(new WeatherDataSource.DetailForeCastReceiver() {
            @Override
            public void OnDetailFOreCastReceived(ForeCastDayDetail detailForeCast) {
                foreCastDayDetail = detailForeCast;
            }

            @Override
            public void onError() {
                foreCastDayDetail = null;
            }
        }, 8);

        CountDownLatch lock = new CountDownLatch(1);
        lock.await(5, TimeUnit.SECONDS);

        Assert.assertNotNull(foreCastDayDetail);

    }

    @Before
    public void setUp() throws Exception {

        weatherDataRepository = DaggerWeatherDataRepositoryComponent.builder()
                .weatherAPIModule(new WeatherAPIModule())
                .build()
                .getWeatherDataRepository();

    }
}