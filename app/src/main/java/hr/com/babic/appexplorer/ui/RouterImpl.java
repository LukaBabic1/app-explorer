package hr.com.babic.appexplorer.ui;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

public final class RouterImpl implements Router {

    // TODO
    private static final int CONTAINER_ID = 0;

    private final Activity activity;
    private final FragmentManager fragmentManager;

    public RouterImpl(final Activity activity, final FragmentManager fragmentManager) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
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
