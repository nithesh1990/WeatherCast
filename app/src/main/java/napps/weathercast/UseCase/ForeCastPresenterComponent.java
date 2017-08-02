package napps.weathercast.UseCase;

import dagger.Component;
import napps.weathercast.Data.WeatherDataRepositoryComponent;
import napps.weathercast.Utils.ActivityScope;
import napps.weathercast.View.Adapter.ForeCastAdapterModule;
import napps.weathercast.View.MainActivity;

/**
 * Created by "nithesh" on 8/1/2017.
 */

@ActivityScope
@Component(dependencies = WeatherDataRepositoryComponent.class, modules = {ForeCastAdapterModule.class, ForeCastPresenterModule.class})
public interface ForeCastPresenterComponent {

    void inject(MainActivity homeActivity);

    ForeCastPresenter getForeCastPresenter();

}
