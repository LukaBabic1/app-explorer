package hr.com.babic.appexplorer.ui;

import com.hr.babic.domain.model.AppIdentifier;

public interface Router {

    void showInstalledAppsOverviewScreen();

    void showAppDetails(AppIdentifier appIdentifier);

    void goBack();
}
