package hr.com.babic.device.repository;

import com.annimon.stream.Stream;
import com.hr.babic.domain.model.AppIdentifier;
import com.hr.babic.domain.model.AppInformation;
import com.hr.babic.domain.repository.ApplicationRepository;

import java.util.List;

import hr.com.babic.device.info.PackageInformationProvider;
import hr.com.babic.device.model.PackageInformation;
import rx.Single;

public final class ApplicationRepositoryImpl implements ApplicationRepository {

    private final PackageInformationProvider packageInformationProvider;

    public ApplicationRepositoryImpl(final PackageInformationProvider packageInformationProvider) {
        this.packageInformationProvider = packageInformationProvider;
    }

    @Override
    public Single<List<AppInformation>> getInstalledApps() {
        return Single.fromCallable(packageInformationProvider::getInstalledPackages)
                     .map(this::toAppInformationList);
    }

    private List<AppInformation> toAppInformationList(final List<PackageInformation> packageInformationList) {
        return Stream.of(packageInformationList)
                     .map(this::toAppInformation)
                     .toList();
    }

    private AppInformation toAppInformation(final PackageInformation information) {
        return new AppInformation(new AppIdentifier(information.packageId), information.appName, information.versionCode, information.versionName);
    }
}
