package napps.weathercast.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import napps.weathercast.Contract.ForeCastAdapterViewContract;
import napps.weathercast.Contract.ViewPresenter.ForeCastViewContract;
import napps.weathercast.Model.ForeCastDayDetail;
import napps.weathercast.Model.Forecastday;
import napps.weathercast.R;
import napps.weathercast.UseCase.DaggerForeCastPresenterComponent;
import napps.weathercast.UseCase.ForeCastPresenter;
import napps.weathercast.UseCase.ForeCastPresenterModule;
import napps.weathercast.View.Adapter.ForeCastAdapterModule;
import napps.weathercast.View.Adapter.ForecastListAdapter;
import napps.weathercast.WeatherApplication;

public class MainActivity extends AppCompatActivity implements ForeCastViewContract.View, ForeCastAdapterViewContract.View{

    @Inject
    ForeCastPresenter foreCastPresenter;

    @Inject
    ForecastListAdapter forecastListAdapter;

    FloatingActionButton searchForecastButton;

    EditText editText;

    RecyclerView foreCastRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerForeCastPresenterComponent.builder()
                .foreCastPresenterModule(new ForeCastPresenterModule(this))
                .weatherDataRepositoryComponent(((WeatherApplication)getApplication()).getWeatherDataComponent())
                .foreCastAdapterModule(new ForeCastAdapterModule(this))
                .build()
                .inject(this);


        searchForecastButton = (FloatingActionButton) findViewById(R.id.fab);
        searchForecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foreCastPresenter.getWeatherForeCast();
            }
        });

        initializeViews();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(!editText.getEditableText().toString().isEmpty()){
            foreCastPresenter.getWeatherForeCast();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initializeViews(){
        editText = (EditText) findViewById(R.id.zipcode_edittext);
        foreCastRecyclerView = (RecyclerView) findViewById(R.id.forecast_listview);
        foreCastRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        foreCastRecyclerView.setAdapter(forecastListAdapter);
    }


    @Override
    public void showForeCastError() {
        Toast.makeText(this, getResources().getString(R.string.forecast_error), Toast.LENGTH_LONG ).show();
    }

    @Override
    public void showForeCastList(List<Forecastday> foreCastList) {
        forecastListAdapter.setForeCastList(foreCastList);
    }

    @Override
    public void showDetailForeCast(ForeCastDayDetail foreCastDayDetail) {
        Intent activity = new Intent(this, DetailForeCastActivity.class);
        activity.putExtra(DetailForeCastActivity.FORECAST_DETAIL, new Gson().toJson(foreCastDayDetail));
        startActivity(activity);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onItemClick(int itemId) {
        foreCastPresenter.getDetailForeCast(itemId);
    }

    @Override
    public String getZipCode() {
        return editText.getEditableText().toString();
    }

    @Override
    public void showZipCodeError() {
        Toast.makeText(this, getResources().getString(R.string.zipcode_error), Toast.LENGTH_LONG ).show();
    }


}
