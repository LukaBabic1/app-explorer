package com.hr.babic.domain.interactor;

import com.hr.babic.domain.model.ActivityInformation;
import com.hr.babic.domain.model.AppIdentifier;

import java.util.List;

import rx.Single;

public interface GetActivitiesForApplicationUseCase {

    Single<List<ActivityInformation>> execute(AppIdentifier appIdentifier);
}
