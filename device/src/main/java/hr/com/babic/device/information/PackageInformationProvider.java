package hr.com.babic.device.information;

import java.util.List;

public interface PackageInformationProvider {

    List<PackageData> getInstalledPackages();

    List<ActivityData> getActivitiesForPackage(String packageId);

    List<ServiceData> getServicesForPackage(String packageId);
}
