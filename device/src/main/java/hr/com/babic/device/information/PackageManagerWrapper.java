package hr.com.babic.device.information;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;

import com.annimon.stream.Stream;

import java.util.Collections;
import java.util.List;

public final class PackageManagerWrapper implements PackageInformationProvider {

    private static final int NO_FLAG = 0;
    private static final int ZERO_COUNT = 0;

    private final PackageManager packageManager;
    private final Resources resources;

    public PackageManagerWrapper(final PackageManager packageManager, final Resources resources) {
        this.packageManager = packageManager;
        this.resources = resources;
    }

    @Override
    public List<PackageData> getInstalledPackages() {
        return Stream.of(packageManager.getInstalledPackages(NO_FLAG))
                     .map(this::toPackageInformation)
                     .toList();
    }

    private PackageData toPackageInformation(final PackageInfo info) {
        return new PackageData(info.packageName.trim(), getAppLabel(info), info.versionCode, info.versionName);
    }

    private String getAppLabel(final PackageInfo packageInfo) {
        return packageManager.getApplicationLabel(packageInfo.applicationInfo).toString().trim();
    }

    @Override
    public List<ActivityData> getActivitiesForPackage(final String packageId) {
        final PackageInfo packageInfo = getPackageInfoForPackage(packageId, PackageManager.GET_ACTIVITIES);

        if (areActivitiesAvailable(packageInfo)) {
            return toActivityData(packageInfo.activities);
        } else {
            return Collections.emptyList();
        }
    }

    private boolean areActivitiesAvailable(final PackageInfo packageInfo) {
        return packageInfo != null && packageInfo.activities != null && packageInfo.activities.length > ZERO_COUNT;
    }

    private List<ActivityData> toActivityData(final ActivityInfo[] activityInfos) {
        return Stream.of(activityInfos)
                     .map(this::toActivityData)
                     .toList();
    }

    private ActivityData toActivityData(final ActivityInfo activityInfo) {
        return new ActivityData(activityInfo.name.trim());
    }

    @Override
    public List<ServiceData> getServicesForPackage(final String packageId) {
        final PackageInfo packageInfo = getPackageInfoForPackage(packageId, PackageManager.GET_SERVICES);

        if (areServicesAvailable(packageInfo)) {
            return toServiceData(packageInfo.services);
        } else {
            return Collections.emptyList();
        }
    }

    private boolean areServicesAvailable(final PackageInfo packageInfo) {
        return packageInfo != null && packageInfo.services != null && packageInfo.services.length > ZERO_COUNT;
    }

    private List<ServiceData> toServiceData(final ServiceInfo[] serviceInfos) {
        return Stream.of(serviceInfos)
                     .map(this::toServiceData)
                     .toList();
    }

    private ServiceData toServiceData(final ServiceInfo serviceInfo) {
        return new ServiceData(serviceInfo.name.trim());
    }

    private PackageInfo getPackageInfoForPackage(final String packageId, final int flags) {
        PackageInfo packageInfo;
        try {
            packageInfo = packageManager.getPackageInfo(packageId, flags);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }

        return packageInfo;
    }
}
