package com.hr.babic.domain.interactor;

import com.hr.babic.domain.model.ApplicationInformation;
import com.hr.babic.domain.repository.ApplicationRepository;

import java.util.List;

import rx.Single;

public final class GetInstalledAppsUseCaseImpl implements GetInstalledAppsUseCase {

    private final ApplicationRepository applicationRepository;

    public GetInstalledAppsUseCaseImpl(final ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Single<List<ApplicationInformation>> execute() {
        return applicationRepository.getInstalledApps();
    }
}
