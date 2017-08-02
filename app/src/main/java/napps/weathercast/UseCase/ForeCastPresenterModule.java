package napps.weathercast.UseCase;

import dagger.Module;
import dagger.Provides;
import napps.weathercast.Contract.ViewPresenter.ForeCastViewContract;

/**
 * Created by "nithesh" on 8/1/2017.
 */

@Module
public class ForeCastPresenterModule {

    private final ForeCastViewContract.View mView;

    public ForeCastPresenterModule(ForeCastViewContract.View view){
        mView = view;
    }

    @Provides
    ForeCastViewContract.View providesForeCastView(){
        return mView;
    }
}
