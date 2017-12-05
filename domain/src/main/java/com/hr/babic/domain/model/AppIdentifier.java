package com.hr.babic.domain.model;

import java.io.Serializable;

public final class AppIdentifier implements Serializable {

    public static final AppIdentifier EMPTY = new AppIdentifier("");

    public final String appId;

    public AppIdentifier(final String appId) {
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

        AppIdentifier that = (AppIdentifier) o;

        return appId != null ? appId.equals(that.appId) : that.appId == null;

    }

    @Override
    public int hashCode() {
        return appId != null ? appId.hashCode() : 0;
    }
}
