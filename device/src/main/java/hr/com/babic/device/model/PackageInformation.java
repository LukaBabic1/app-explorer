package hr.com.babic.device.model;

public final class PackageInformation {

    public final String packageId;
    public final String appName;
    public final int versionCode;
    public final String versionName;

    public PackageInformation(final String packageId, final String appName, final int versionCode, final String versionName) {
        this.packageId = packageId;
        this.appName = appName;
        this.versionCode = versionCode;
        this.versionName = versionName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PackageInformation that = (PackageInformation) o;

        if (versionCode != that.versionCode) {
            return false;
        }
        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) {
            return false;
        }
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) {
            return false;
        }
        return versionName != null ? versionName.equals(that.versionName) : that.versionName == null;
    }

    @Override
    public int hashCode() {
        int result = packageId != null ? packageId.hashCode() : 0;
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + versionCode;
        result = 31 * result + (versionName != null ? versionName.hashCode() : 0);
        return result;
    }
}
