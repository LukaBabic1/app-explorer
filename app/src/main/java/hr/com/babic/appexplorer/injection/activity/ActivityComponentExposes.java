package hr.com.babic.appexplorer.injection.activity;

import hr.com.babic.appexplorer.injection.activity.module.ActivityModule;
import hr.com.babic.appexplorer.injection.application.ApplicationComponentExposes;

public interface ActivityComponentExposes extends ApplicationComponentExposes,
                                                  ActivityModule.Exposes { }
