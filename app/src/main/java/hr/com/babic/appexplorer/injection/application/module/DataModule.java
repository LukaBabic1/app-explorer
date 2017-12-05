package hr.com.babic.appexplorer.injection.application.module;

import com.hr.babic.domain.repository.ApplicationRepository;

import dagger.Module;
import dagger.Provides;
import hr.com.babic.device.information.ApplicationRepositoryImpl;
import hr.com.babic.device.information.PackageInformationProvider;

@Module
public final class DataModule {

    @Provides
    ApplicationRepository provideApplicationRepository(final PackageInformationProvider packageInformationProvider) {
        return new ApplicationRepositoryImpl(packageInformationProvider);
    }

    public interface Exposes {

        ApplicationRepository applicationRepository();
    }
}
