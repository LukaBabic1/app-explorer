package com.hr.babic.domain.interactor;

import com.hr.babic.domain.model.ActivityInformation;
import com.hr.babic.domain.model.AppIdentifier;
import com.hr.babic.domain.repository.ApplicationRepository;

import java.util.List;

import rx.Single;

public final class GetActivitiesForApplicationUseCaseImpl implements GetActivitiesForApplicationUseCase {

    private final ApplicationRepository applicationRepository;

    public GetActivitiesForApplicationUseCaseImpl(final ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Single<List<ActivityInformation>> execute(final AppIdentifier appIdentifier) {
        return applicationRepository.getActivitiesForApp(appIdentifier);
    }
}
