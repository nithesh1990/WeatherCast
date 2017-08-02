package napps.weathercast.Data;

import android.support.annotation.IntRange;
import android.text.format.DateUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import napps.weathercast.Contract.ModelView.WeatherDataSource;
import napps.weathercast.Model.Weather;
import napps.weathercast.Network.WeatherAPIService;
import napps.weathercast.Utils.Constants;

/**
 * Created by "nithesh" on 8/1/2017.
 */

@Singleton
public class WeatherDataRepository implements WeatherDataSource {

    private static Weather cachedData;

    WeatherAPIService mWeatherAPIService;

    @Inject
    public WeatherDataRepository(WeatherAPIService weatherAPIService){
        mWeatherAPIService = weatherAPIService;
    }

    @Override
    public void getWeatherForeCast(final WeatherForeCastReceiver weatherForeCastReceiver, String zipCode) {
        if(cachedData != null && isCacheValid(zipCode)){
            weatherForeCastReceiver.OnForeCastReceived(cachedData.getForecast().getTxtForecast().getForecastday());
            return;
        }

        Observable<Weather> weatherObservable = mWeatherAPIService.getWeatherData(Constants.API_KEY, zipCode);
        weatherObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Weather value) {
                        if(value.getForecast() == null){
                            weatherForeCastReceiver.onError();
                            return;
                        }

                        for(int pos = 0;  pos < value.getForecast().getSimpleforecast().getForecastday().size(); pos++){
                            value.getForecast().getSimpleforecast().getForecastday().get(pos).setDetailText(
                                    value.getForecast().getTxtForecast().getForecastday().get(pos*2).getFcttext()
                            );
                        }
                        weatherForeCastReceiver.OnForeCastReceived(value.getForecast().getTxtForecast().getForecastday());

                        cachedData = value;
                    }

                    @Override
                    public void onError(Throwable e) {
                        weatherForeCastReceiver.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getDetailForeCastforDay(DetailForeCastReceiver detailForeCastReceiver, @IntRange(from = 0, to = 10) int dayNumber) {
        if(cachedData == null){
            detailForeCastReceiver.onError();
            return;
        }
        detailForeCastReceiver.OnDetailFOreCastReceived(cachedData.getForecast().getSimpleforecast().getForecastday().get(dayNumber));
    }

    private boolean isCacheValid(String zipCode){
        return DateUtils.isToday(cachedData.getTimeStamp())
                    && cachedData.getZipcode().equals(zipCode);
    }
}
