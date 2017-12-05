package hr.com.babic.appexplorer.base;

public interface ScopedPresenter {

    void start();

    void activate();

    void deactivate();

    void stop();

    void destroy();

    void back();
}

