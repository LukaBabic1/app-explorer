package com.hr.babic.domain.repository;

import com.hr.babic.domain.model.AppInformation;

import java.util.List;

import rx.Single;

public interface ApplicationRepository {

    Single<List<AppInformation>> getInstalledApps();
}
