package napps.weathercast.View.Adapter;

import dagger.Module;
import dagger.Provides;
import napps.weathercast.Contract.ForeCastAdapterViewContract;

/**
 * Created by "nithesh" on 8/1/2017.
 */

@Module
public class ForeCastAdapterModule {

    private final ForeCastAdapterViewContract.View mView;

    public ForeCastAdapterModule(ForeCastAdapterViewContract.View view){
        mView = view;
    }

    @Provides
    public ForeCastAdapterViewContract.View getForeCastDapterView(){
        return mView;
    }
}
