package hr.com.babic.appexplorer.base;

public interface ScopedPresenter {

    ScopedPresenter EMPTY = NoOpScopedPresenter.INSTANCE;

    void start();

    void activate();

    void deactivate();

    void stop();

    void destroy();

    void back();
}

