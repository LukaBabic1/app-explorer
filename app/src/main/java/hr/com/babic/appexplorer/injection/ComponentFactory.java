package hr.com.babic.appexplorer.injection;

import hr.com.babic.appexplorer.app.AppExplorerApplication;
import hr.com.babic.appexplorer.injection.activity.ActivityComponent;
import hr.com.babic.appexplorer.injection.activity.DaggerActivity;
import hr.com.babic.appexplorer.injection.activity.DaggerActivityComponent;
import hr.com.babic.appexplorer.injection.activity.module.ActivityModule;
import hr.com.babic.appexplorer.injection.activity.module.ActivityPresenterModule;
import hr.com.babic.appexplorer.injection.application.ApplicationComponent;
import hr.com.babic.appexplorer.injection.application.ApplicationModule;
import hr.com.babic.appexplorer.injection.application.DaggerApplicationComponent;
import hr.com.babic.appexplorer.injection.fragment.DaggerFragment;
import hr.com.babic.appexplorer.injection.fragment.DaggerFragmentComponent;
import hr.com.babic.appexplorer.injection.fragment.FragmentComponent;
import hr.com.babic.appexplorer.injection.fragment.module.FragmentPresenterModule;

public final class ComponentFactory {

    public static ApplicationComponent createApplicationComponent(final AppExplorerApplication application) {
        return DaggerApplicationComponent.builder()
                                         .applicationModule(new ApplicationModule(application))
                                         .build();
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity activity, final AppExplorerApplication application) {
        return DaggerActivityComponent.builder()
                                      .applicationComponent(application.getApplicationComponent())
                                      .activityModule(new ActivityModule(activity))
                                      .activityPresenterModule(new ActivityPresenterModule(activity))
                                      .build();
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment fragment, final ActivityComponent component) {
        return DaggerFragmentComponent.builder()
                                      .activityComponent(component)
                                      .fragmentPresenterModule(new FragmentPresenterModule(fragment))
                                      .build();
    }
}
