package hr.com.babic.appexplorer.injection.activity.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
import hr.com.babic.appexplorer.base.NoOpScopedPresenter;
import hr.com.babic.appexplorer.injection.ForActivity;
import hr.com.babic.appexplorer.injection.activity.DaggerActivity;
import hr.com.babic.appexplorer.injection.scope.ActivityScope;
import hr.com.babic.appexplorer.ui.Router;
import hr.com.babic.appexplorer.ui.RouterImpl;
import hr.com.babic.appexplorer.ui.overview.InstalledAppsAdapter;
import hr.com.babic.appexplorer.util.ActivityUtils;
import hr.com.babic.appexplorer.util.ActivityUtilsImpl;

@Module
public final class ActivityModule {

    private final DaggerActivity activity;

    public ActivityModule(final DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    ActivityUtils provideActivityUtils() {
        return new ActivityUtilsImpl();
    }

    @Provides
    @ForActivity
    Context provideActivityContext() {
        return activity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    Router provideRouter(final FragmentManager fragmentManager) {
        return new RouterImpl(activity, fragmentManager);
    }

    @Provides
    @ActivityScope
    LayoutInflater provideLayoutInflater(@ForActivity final Context context) {
        return LayoutInflater.from(context);
    }

    @Provides
    InstalledAppsAdapter provideInstalledAppsAdapter(final LayoutInflater inflater) {
        return new InstalledAppsAdapter(inflater);
    }

    @Provides
    NoOpScopedPresenter provideNoOpScopedPresenter() {
        final NoOpScopedPresenter presenter = new NoOpScopedPresenter();
        activity.getActivityComponent().inject(presenter);

        return presenter;
    }

    public interface Exposes {

        ActivityUtils activityUtils();

        @ForActivity
        Context provideActivityContext();

        Router router();

        InstalledAppsAdapter installedAppsAdapter();
    }
}
