package com.hr.babic.domain.model;

public final class ApplicationIdenfitier {

    public final String appId;

    public ApplicationIdenfitier(final String appId) {
        this.appId = appId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ApplicationIdenfitier that = (ApplicationIdenfitier) o;

        return appId != null ? appId.equals(that.appId) : that.appId == null;

    }

    @Override
    public int hashCode() {
        return appId != null ? appId.hashCode() : 0;
    }
}
