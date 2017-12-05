package hr.com.babic.appexplorer.ui;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import com.hr.babic.domain.model.AppIdentifier;

import hr.com.babic.appexplorer.R;
import hr.com.babic.appexplorer.ui.appdetails.AppDetailsFragment;
import hr.com.babic.appexplorer.ui.overview.InstalledAppsOverviewFragment;

public final class RouterImpl implements Router {

    private static final int CONTAINER_ID = R.id.activity_main_fragment_container;

    private final Activity activity;
    private final FragmentManager fragmentManager;

    public RouterImpl(final Activity activity, final FragmentManager fragmentManager) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void showInstalledAppsOverviewScreen() {
        fragmentManager.beginTransaction()
                       .replace(CONTAINER_ID, InstalledAppsOverviewFragment.newInstance(), InstalledAppsOverviewFragment.TAG)
                       .commit();
    }

    @Override
    public void showAppDetails(final AppIdentifier appIdentifier) {
        fragmentManager.beginTransaction()
                       .replace(CONTAINER_ID, AppDetailsFragment.newInstance(appIdentifier), AppDetailsFragment.TAG)
                       .addToBackStack(null)
                       .commit();
    }

    @Override
    public void goBack() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            activity.finish();
        } else {
            fragmentManager.popBackStack();
        }
    }
}
