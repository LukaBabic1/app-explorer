package hr.com.babic.appexplorer.injection.fragment.module;

import dagger.Module;
import dagger.Provides;
import hr.com.babic.appexplorer.injection.fragment.DaggerFragment;
import hr.com.babic.appexplorer.injection.scope.FragmentScope;
import hr.com.babic.appexplorer.ui.appdetails.AppDetailsContract;
import hr.com.babic.appexplorer.ui.appdetails.AppDetailsPresenter;
import hr.com.babic.appexplorer.ui.overview.InstalledAppsOverviewContract;
import hr.com.babic.appexplorer.ui.overview.InstalledAppsOverviewPresenter;

@Module
public final class FragmentPresenterModule {

    private final DaggerFragment fragment;

    public FragmentPresenterModule(final DaggerFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    InstalledAppsOverviewContract.Presenter provideInstalledAppsOverviewPresenter() {
        final InstalledAppsOverviewPresenter presenter = new InstalledAppsOverviewPresenter((InstalledAppsOverviewContract.View) fragment);
        fragment.getFragmentComponent().inject(presenter);

        return presenter;
    }

    @Provides
    @FragmentScope
    AppDetailsContract.Presenter provideAppDetailsPresenter() {
        final AppDetailsPresenter presenter = new AppDetailsPresenter((AppDetailsContract.View) fragment);
        fragment.getFragmentComponent().inject(presenter);

        return presenter;
    }

    public interface Exposes {

        InstalledAppsOverviewContract.Presenter installedAppsOverviewPresenter();

        AppDetailsContract.Presenter appDetailsPresenter();
    }
}
