package hr.com.babic.appexplorer.injection.activity;

import hr.com.babic.appexplorer.injection.activity.module.ActivityModule;
import hr.com.babic.appexplorer.injection.application.ApplicationComponentExposes;
import hr.com.babic.appexplorer.injection.application.module.UseCaseModule;

public interface ActivityComponentExposes extends ApplicationComponentExposes,
                                                  ActivityModule.Exposes,
                                                  UseCaseModule.Exposes { }
