package hr.com.babic.appexplorer.injection.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hr.com.babic.appexplorer.app.AppExplorerApplication;
import hr.com.babic.appexplorer.injection.ComponentFactory;

public abstract class DaggerActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getActivityComponent());
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this, getAppExplorerApplication());
        }

        return activityComponent;
    }

    private AppExplorerApplication getAppExplorerApplication() {
        return AppExplorerApplication.from(this);
    }

    protected abstract void inject(final ActivityComponent component);
}

