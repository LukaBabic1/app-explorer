package hr.com.babic.appexplorer.injection.application;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.com.babic.appexplorer.app.AppExplorerApplication;
import hr.com.babic.appexplorer.injection.ForApplication;

@Module
public final class ApplicationModule {

    private final AppExplorerApplication application;

    public ApplicationModule(final AppExplorerApplication application) {
        this.application = application;
    }

    @Provides
    @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }

    public interface Exposes {

        @ForApplication
        Context context();

        Resources resources();
    }
}
