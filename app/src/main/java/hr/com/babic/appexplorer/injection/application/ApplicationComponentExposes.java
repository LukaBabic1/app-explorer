package hr.com.babic.appexplorer.injection.application;

import hr.com.babic.appexplorer.injection.application.module.ApiModule;
import hr.com.babic.appexplorer.injection.application.module.DataModule;
import hr.com.babic.appexplorer.injection.application.module.DeviceModule;
import hr.com.babic.appexplorer.injection.application.module.ThreadingModule;
import hr.com.babic.appexplorer.injection.application.module.UseCaseModule;
import hr.com.babic.appexplorer.injection.application.module.UtilsModule;

public interface ApplicationComponentExposes extends ApplicationModule.Exposes,
                                                     ApiModule.Exposes,
                                                     DataModule.Exposes,
                                                     DeviceModule.Exposes,
                                                     ThreadingModule.Exposes,
                                                     UseCaseModule.Exposes,
                                                     UtilsModule.Exposes { }
