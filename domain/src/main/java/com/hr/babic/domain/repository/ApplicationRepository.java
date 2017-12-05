package com.hr.babic.domain.repository;

import com.hr.babic.domain.model.ActivityInformation;
import com.hr.babic.domain.model.AppIdentifier;
import com.hr.babic.domain.model.AppInformation;

import java.util.List;

import rx.Single;

public interface ApplicationRepository {

    Single<List<AppInformation>> getInstalledApps();

    Single<List<ActivityInformation>> getActivitiesForApp(AppIdentifier appIdentifier);
}
