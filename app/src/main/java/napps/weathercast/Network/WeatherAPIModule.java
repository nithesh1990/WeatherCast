package napps.weathercast.Network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import napps.weathercast.Utils.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by "nithesh" on 8/1/2017.
 */
@Singleton
@Module
public class WeatherAPIModule {

    @Provides
    @Singleton
    Gson providesGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://"+ Constants.WEATHER_UNDERGROUND_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(providesGson()))
                .build();

    }

    @Provides
    @Singleton
    WeatherAPIService providesWeatherAPIService(Retrofit retrofit){
        return retrofit.create(WeatherAPIService.class);
    }
}
