package hr.com.babic.appexplorer.injection.fragment;

import hr.com.babic.appexplorer.base.NoOpScopedPresenter;
import hr.com.babic.appexplorer.ui.appdetails.AppDetailsFragment;
import hr.com.babic.appexplorer.ui.appdetails.AppDetailsPresenter;
import hr.com.babic.appexplorer.ui.overview.InstalledAppsOverviewFragment;
import hr.com.babic.appexplorer.ui.overview.InstalledAppsOverviewPresenter;

public interface FragmentComponentInjects {

    void inject(NoOpScopedPresenter presenter);

    void inject(InstalledAppsOverviewPresenter presenter);

    void inject(InstalledAppsOverviewFragment fragment);

    void inject(AppDetailsFragment fragment);

    void inject(AppDetailsPresenter presenter);
}
