package hr.com.babic.appexplorer.app;

import android.app.Application;
import android.content.Context;

public final class AppExplorerApplication extends Application {

    public static AppExplorerApplication from(final Context context) {
        return (AppExplorerApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
