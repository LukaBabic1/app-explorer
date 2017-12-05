package hr.com.babic.appexplorer.injection.activity;

import dagger.Component;
import hr.com.babic.appexplorer.injection.activity.module.ActivityModule;
import hr.com.babic.appexplorer.injection.activity.module.ActivityPresenterModule;
import hr.com.babic.appexplorer.injection.application.ApplicationComponent;
import hr.com.babic.appexplorer.injection.scope.ActivityScope;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                ActivityModule.class,
                ActivityPresenterModule.class,
        }
)
public interface ActivityComponent extends ActivityComponentInjects, ActivityComponentExposes {}
