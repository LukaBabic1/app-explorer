package hr.com.babic.appexplorer.injection.activity.module;

import dagger.Module;
import hr.com.babic.appexplorer.injection.activity.DaggerActivity;

@Module
public final class ActivityPresenterModule {

    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }
}
