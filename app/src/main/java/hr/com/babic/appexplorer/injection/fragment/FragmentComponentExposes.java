package hr.com.babic.appexplorer.injection.fragment;

import hr.com.babic.appexplorer.injection.activity.ActivityComponentExposes;
import hr.com.babic.appexplorer.injection.fragment.module.FragmentPresenterModule;

public interface FragmentComponentExposes extends ActivityComponentExposes,
                                                  FragmentPresenterModule.Exposes { }
