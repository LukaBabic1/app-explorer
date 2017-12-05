package hr.com.babic.appexplorer.injection.application;

import javax.inject.Singleton;

import dagger.Component;
import hr.com.babic.appexplorer.injection.application.module.ApiModule;
import hr.com.babic.appexplorer.injection.application.module.DataModule;
import hr.com.babic.appexplorer.injection.application.module.DeviceModule;
import hr.com.babic.appexplorer.injection.application.module.ThreadingModule;
import hr.com.babic.appexplorer.injection.application.module.UseCaseModule;
import hr.com.babic.appexplorer.injection.application.module.UtilsModule;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class,
                DataModule.class,
                DeviceModule.class,
                ThreadingModule.class,
                UseCaseModule.class,
                UtilsModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects,
                                              ApplicationComponentExposes { }
