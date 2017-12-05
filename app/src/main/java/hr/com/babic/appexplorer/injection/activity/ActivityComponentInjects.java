package hr.com.babic.appexplorer.injection.activity;

import hr.com.babic.appexplorer.base.NoOpScopedPresenter;
import hr.com.babic.appexplorer.ui.main.MainActivity;

public interface ActivityComponentInjects {

    void inject(MainActivity activity);

    void inject(NoOpScopedPresenter presenter);
}
