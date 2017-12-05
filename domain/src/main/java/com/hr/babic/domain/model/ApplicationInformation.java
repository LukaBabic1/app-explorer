package com.hr.babic.domain.model;

public final class ApplicationInformation {

    public final AppIdentifier appIdentifier;
    public final String name;
    public final int versionCode;
    public final String versionName;

    public ApplicationInformation(final AppIdentifier appIdentifier, final String name, final int versionCode, final String versionName) {
        this.appIdentifier = appIdentifier;
        this.name = name;
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

        ApplicationInformation that = (ApplicationInformation) o;

        if (versionCode != that.versionCode) {
            return false;
        }
        if (appIdentifier != null ? !appIdentifier.equals(that.appIdentifier) : that.appIdentifier != null) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return versionName != null ? versionName.equals(that.versionName) : that.versionName == null;

    }

    @Override
    public int hashCode() {
        int result = appIdentifier != null ? appIdentifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + versionCode;
        result = 31 * result + (versionName != null ? versionName.hashCode() : 0);
        return result;
    }
}
