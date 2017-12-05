package hr.com.babic.device.info;

import java.util.List;

import hr.com.babic.device.model.PackageInformation;

public interface PackageInformationProvider {

    List<PackageInformation> getInstalledPackages();
}
