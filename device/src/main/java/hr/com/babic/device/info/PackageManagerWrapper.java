package hr.com.babic.device.info;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.annimon.stream.Stream;

import java.util.List;

import hr.com.babic.device.model.PackageInformation;

public final class PackageManagerWrapper implements PackageInformationProvider {

    private static final int NO_FLAG = 0;

    private final PackageManager packageManager;

    public PackageManagerWrapper(final PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    @Override
    public List<PackageInformation> getInstalledPackages() {
        return Stream.of(packageManager.getInstalledPackages(NO_FLAG))
                     .map(this::toPackageInformation)
                     .toList();
    }

    private PackageInformation toPackageInformation(final PackageInfo info) {
        return new PackageInformation(info.packageName, info.applicationInfo.name, info.versionCode, info.versionName);
    }
}
