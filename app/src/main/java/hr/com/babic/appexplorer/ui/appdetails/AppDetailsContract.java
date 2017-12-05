package hr.com.babic.appexplorer.ui.appdetails;

import com.hr.babic.domain.model.AppIdentifier;

import java.util.List;

import hr.com.babic.appexplorer.base.BaseView;
import hr.com.babic.appexplorer.base.ScopedPresenter;

public final class AppDetailsContract {

    private AppDetailsContract() {

    }

    public interface Presenter extends ScopedPresenter {

        void init(AppIdentifier appIdentifier);
    }

    public interface View extends BaseView {

        void render(ViewModel viewModel);
    }

    public static final class ViewModel {

        public final List<AppActivityViewModel> viewModels;

        public ViewModel(final List<AppActivityViewModel> viewModels) {
            this.viewModels = viewModels;
        }
    }

    public static final class AppActivityViewModel {

        public final String name;

        public AppActivityViewModel(final String name) {
            this.name = name;
        }
    }
}
