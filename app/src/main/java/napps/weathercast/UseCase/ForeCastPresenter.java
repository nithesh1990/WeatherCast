package napps.weathercast.UseCase;

import java.util.List;

import javax.inject.Inject;

import napps.weathercast.Contract.ModelView.WeatherDataSource;
import napps.weathercast.Contract.ViewPresenter.ForeCastViewContract;
import napps.weathercast.Data.WeatherDataRepository;
import napps.weathercast.Model.ForeCastDayDetail;
import napps.weathercast.Model.Forecastday;
import napps.weathercast.Utils.Constants;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class ForeCastPresenter implements ForeCastViewContract.Presenter {

    ForeCastViewContract.View mView;

    WeatherDataRepository mWeatherDataRepository;

    @Inject
    public ForeCastPresenter(ForeCastViewContract.View view, WeatherDataRepository weatherDataRepository){
        mView = view;
        mWeatherDataRepository = weatherDataRepository;
    }

    @Override
    public void getWeatherForeCast() {
        String zipCodeText = mView.getZipCode();
        if(!isZipCodeValid(zipCodeText)){
            mView.showZipCodeError();
            return;
        }

        mWeatherDataRepository.getWeatherForeCast(new WeatherDataSource.WeatherForeCastReceiver() {
            @Override
            public void OnForeCastReceived(List<Forecastday> forecastDayList) {
                mView.showForeCastList(forecastDayList);
            }

            @Override
            public void onError() {
                mView.showForeCastError();
            }
        }, zipCodeText);

    }

    @Override
    public void getDetailForeCast(int dayNumber) {
        mWeatherDataRepository.getDetailForeCastforDay(new WeatherDataSource.DetailForeCastReceiver() {
            @Override
            public void OnDetailFOreCastReceived(ForeCastDayDetail detailForeCast) {
                mView.showDetailForeCast(detailForeCast);
            }

            @Override
            public void onError() {
                mView.showForeCastError();
            }
        }, dayNumber);
    }

    private boolean isZipCodeValid(String zipCode){
        if(zipCode == null){
            return false;
        }

        if(zipCode.isEmpty() || !zipCode.matches("^[0-9]*$") || zipCode.length() != Constants.ZIPCODE_LENGTH){
            return false;
        }

        return true;
    }
}
