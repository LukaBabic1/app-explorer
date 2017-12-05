package hr.com.babic.appexplorer.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import javax.inject.Inject;

import hr.com.babic.appexplorer.injection.activity.DaggerActivity;
import hr.com.babic.appexplorer.util.ActivityUtils;

public abstract class BaseActivity extends DaggerActivity {

    @Inject
    protected FragmentManager fragmentManager;

    @Inject
    ActivityUtils activityUtils;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startPresenter();
    }

    private void startPresenter() {
        getPresenter().start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().activate();
    }

    @Override
    protected void onPause() {
        getPresenter().deactivate();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (!activityUtils.propagateBackToTopFragment(fragmentManager)) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        if (isFinishing()) {
            getPresenter().destroy();
            clearFragments();
        }
        super.onDestroy();
    }

    @SuppressWarnings("Convert2streamapi")
    private void clearFragments() {
        final List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (final Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).onPreDestroy();
                }
            }
        }
    }

    protected abstract ScopedPresenter getPresenter();
}
