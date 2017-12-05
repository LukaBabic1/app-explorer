package hr.com.babic.appexplorer.ui.overview;

import com.hr.babic.domain.model.AppIdentifier;

import java.util.List;

import hr.com.babic.appexplorer.base.BaseView;
import hr.com.babic.appexplorer.base.ScopedPresenter;

public final class InstalledAppsOverviewContract {

    private InstalledAppsOverviewContract() {

    }

    public interface Presenter extends ScopedPresenter {

    }

    public interface View extends BaseView {

        void render(ViewModel viewModel);
    }

    public static final class ViewModel {

        public final List<InstalledAppViewModel> viewModels;

        public ViewModel(final List<InstalledAppViewModel> viewModels) {
            this.viewModels = viewModels;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ViewModel viewModel = (ViewModel) o;

            return viewModels != null ? viewModels.equals(viewModel.viewModels) : viewModel.viewModels == null;

        }

        @Override
        public int hashCode() {
            return viewModels != null ? viewModels.hashCode() : 0;
        }
    }

    public static final class InstalledAppViewModel {

        public final AppIdentifier appIdentifier;
        public final String appName;

        public InstalledAppViewModel(final AppIdentifier appIdentifier, final String appName) {
            this.appIdentifier = appIdentifier;
            this.appName = appName;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            InstalledAppViewModel that = (InstalledAppViewModel) o;

            if (appIdentifier != null ? !appIdentifier.equals(that.appIdentifier) : that.appIdentifier != null) {
                return false;
            }
            return appName != null ? appName.equals(that.appName) : that.appName == null;

        }

        @Override
        public int hashCode() {
            int result = appIdentifier != null ? appIdentifier.hashCode() : 0;
            result = 31 * result + (appName != null ? appName.hashCode() : 0);
            return result;
        }
    }
}
