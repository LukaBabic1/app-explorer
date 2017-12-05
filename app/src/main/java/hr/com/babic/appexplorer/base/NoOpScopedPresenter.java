package hr.com.babic.appexplorer.base;

public final class NoOpScopedPresenter extends BasePresenter {

    public NoOpScopedPresenter() {
        super(new BaseView() { });
    }
}
