package hr.com.babic.appexplorer.ui.main;

import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import hr.com.babic.appexplorer.R;
import hr.com.babic.appexplorer.base.BaseActivity;
import hr.com.babic.appexplorer.base.NoOpScopedPresenter;
import hr.com.babic.appexplorer.base.ScopedPresenter;
import hr.com.babic.appexplorer.injection.activity.ActivityComponent;
import hr.com.babic.appexplorer.ui.Router;

public final class MainActivity extends BaseActivity {

    @Inject
    NoOpScopedPresenter presenter;

    @Inject
    Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        if (savedInstanceState == null) {
            router.showInstalledAppsOverviewScreen();
        }
    }

    private void bindViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void inject(final ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected ScopedPresenter getPresenter() {
        return presenter;
    }
}
