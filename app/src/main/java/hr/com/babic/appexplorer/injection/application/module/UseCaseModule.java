package hr.com.babic.appexplorer.injection.application.module;

import com.hr.babic.domain.interactor.GetActivitiesForApplicationUseCase;
import com.hr.babic.domain.interactor.GetActivitiesForApplicationUseCaseImpl;
import com.hr.babic.domain.interactor.GetInstalledAppsUseCase;
import com.hr.babic.domain.interactor.GetInstalledAppsUseCaseImpl;
import com.hr.babic.domain.repository.ApplicationRepository;

import dagger.Module;
import dagger.Provides;

@Module
public final class UseCaseModule {

    @Provides
    GetActivitiesForApplicationUseCase provideGetActivitiesForApplicationUseCase(final ApplicationRepository applicationRepository) {
        return new GetActivitiesForApplicationUseCaseImpl(applicationRepository);
    }

    @Provides
    GetInstalledAppsUseCase provideGetInstalledAppsUseCase(final ApplicationRepository applicationRepository) {
        return new GetInstalledAppsUseCaseImpl(applicationRepository);
    }

    public interface Exposes {

        GetActivitiesForApplicationUseCase getActivitiesForApplicationUseCase();

        GetInstalledAppsUseCase getInstalledAppsUseCase();
    }
}
