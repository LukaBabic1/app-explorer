package hr.com.babic.appexplorer.injection.fragment;

import dagger.Component;
import hr.com.babic.appexplorer.injection.activity.ActivityComponent;
import hr.com.babic.appexplorer.injection.fragment.module.FragmentPresenterModule;
import hr.com.babic.appexplorer.injection.scope.FragmentScope;

@FragmentScope
@Component(
        dependencies = {
                ActivityComponent.class
        },
        modules = {
                FragmentPresenterModule.class
        }
)
public interface FragmentComponent extends FragmentComponentInjects,
                                           FragmentComponentExposes { }
