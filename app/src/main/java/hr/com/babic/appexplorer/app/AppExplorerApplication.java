package hr.com.babic.appexplorer.app;

import android.app.Application;
import android.content.Context;

import hr.com.babic.appexplorer.injection.ComponentFactory;
import hr.com.babic.appexplorer.injection.application.ApplicationComponent;

public final class AppExplorerApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static AppExplorerApplication from(final Context context) {
        return (AppExplorerApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent().inject(this);
    }

    private ApplicationComponent initApplicationComponent() {
        return applicationComponent = ComponentFactory.createApplicationComponent(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
