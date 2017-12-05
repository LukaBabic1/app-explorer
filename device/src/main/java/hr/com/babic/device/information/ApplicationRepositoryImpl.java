package hr.com.babic.device.information;

import com.annimon.stream.Stream;
import com.hr.babic.domain.model.*;
import com.hr.babic.domain.model.ActivityInformation;
import com.hr.babic.domain.repository.ApplicationRepository;

import java.util.List;

import rx.Single;

public final class ApplicationRepositoryImpl implements ApplicationRepository {

    private final PackageInformationProvider packageInformationProvider;

    public ApplicationRepositoryImpl(final PackageInformationProvider packageInformationProvider) {
        this.packageInformationProvider = packageInformationProvider;
    }

    @Override
    public Single<List<ApplicationInformation>> getInstalledApps() {
        return Single.fromCallable(packageInformationProvider::getInstalledPackages)
                     .map(this::toAppInformationList);
    }

    private List<ApplicationInformation> toAppInformationList(final List<PackageData> packageDataList) {
        return Stream.of(packageDataList)
                     .map(this::toAppInformation)
                     .toList();
    }

    private ApplicationInformation toAppInformation(final PackageData information) {
        return new ApplicationInformation(new AppIdentifier(information.packageId), information.appName, information.versionCode, information.versionName);
    }

    @Override
    public Single<List<ActivityInformation>> getActivitiesForApp(final AppIdentifier appIdentifier) {
        return Single.fromCallable(() -> packageInformationProvider.getActivitiesForPackage(appIdentifier.appId))
                     .map(this::toActivityInformationList);
    }

    private List<ActivityInformation> toActivityInformationList(final List<ActivityData> activityDataList) {
        return Stream.of(activityDataList)
                     .map(this::toActivityInformation)
                     .toList();
    }

    private ActivityInformation toActivityInformation(final ActivityData activityData) {
        return new ActivityInformation(activityData.activityName);
    }
}
