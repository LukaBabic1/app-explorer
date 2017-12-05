package hr.com.babic.appexplorer.injection.application.module;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.com.babic.appexplorer.injection.ForApplication;
import hr.com.babic.device.information.PackageInformationProvider;
import hr.com.babic.device.information.PackageManagerWrapper;

@Module
public final class DeviceModule {

    @Provides
    @Singleton
    PackageManager providePackageManager(@ForApplication final Context context) {
        return context.getPackageManager();
    }

    @Provides
    @Singleton
    PackageInformationProvider providePackageInformationProvider(final PackageManager packageManager, final Resources resources) {
        return new PackageManagerWrapper(packageManager, resources);
    }

    public interface Exposes {

        PackageInformationProvider packageInformationProvider();
    }
}
