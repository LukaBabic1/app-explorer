package com.hr.babic.domain.interactor;

import com.hr.babic.domain.model.AppInformation;

import java.util.List;

import rx.Single;

public interface GetInstalledAppsUseCase {

    Single<List<AppInformation>> execute();
}
