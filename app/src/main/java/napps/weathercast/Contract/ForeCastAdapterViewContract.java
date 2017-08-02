package napps.weathercast.Contract;

import android.content.Context;

import java.util.List;

import napps.weathercast.Model.Forecastday;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public interface ForeCastAdapterViewContract {

    interface View {
        Context getContext();
        void onItemClick(int itemId);
    }

    interface Adapter {
        void setForeCastList(List<Forecastday> foreCastList);
    }
}
