package napps.weathercast.UseCase;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import napps.weathercast.Contract.ForeCastAdapterViewContract;
import napps.weathercast.Contract.ViewPresenter.ForeCastViewContract;
import napps.weathercast.Data.DaggerWeatherDataRepositoryComponent;
import napps.weathercast.Data.WeatherDataRepositoryComponent;
import napps.weathercast.Model.ForeCastDayDetail;
import napps.weathercast.Model.Forecastday;
import napps.weathercast.Network.WeatherAPIModule;
import napps.weathercast.View.Adapter.ForeCastAdapterModule;

/**
 * Created by "nithesh" on 8/2/2017.
 */
public class ForeCastPresenterTest {

    @Inject
    ForeCastPresenter foreCastPresenter;

    List<Forecastday> mForecastdayList;

    @Test
    public void getWeatherForeCast() throws Exception {
        ForeCastViewContract.View view = new ForeCastViewContract.View() {
            @Override
            public void showForeCastError() {
                mForecastdayList = null;
            }

            @Override
            public void showForeCastList(List<Forecastday> foreCastList) {
                mForecastdayList = foreCastList;
            }

            @Override
            public String getZipCode() {
                return "85281";
            }

            @Override
            public void showZipCodeError() {

            }

            @Override
            public void showDetailForeCast(ForeCastDayDetail foreCastDayDetail) {

            }
        };

        ForeCastAdapterViewContract.View adapterView = new ForeCastAdapterViewContract.View() {
            @Override
            public Context getContext() {
                return null;
            }

            @Override
            public void onItemClick(int itemId) {

            }

        };
        WeatherDataRepositoryComponent component = DaggerWeatherDataRepositoryComponent.builder()
                .weatherAPIModule(new WeatherAPIModule())
                .build();
        foreCastPresenter = DaggerForeCastPresenterComponent.builder()
                .foreCastPresenterModule(new ForeCastPresenterModule(view))
                .foreCastAdapterModule(new ForeCastAdapterModule(adapterView))
                .weatherDataRepositoryComponent(component)
                .build()
                .getForeCastPresenter();
        foreCastPresenter.getWeatherForeCast();

        CountDownLatch lock = new CountDownLatch(1);

        lock.await(5, TimeUnit.SECONDS);

        Assert.assertNotNull(mForecastdayList);
    }

    @Test
    public void getDetailForeCast() throws Exception {

    }

}