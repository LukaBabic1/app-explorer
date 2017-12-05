package hr.com.babic.appexplorer.ui.overview;

import com.annimon.stream.Stream;
import com.hr.babic.domain.interactor.GetInstalledAppsUseCase;
import com.hr.babic.domain.model.AppInformation;

import java.util.List;

import javax.inject.Inject;

import hr.com.babic.appexplorer.base.BasePresenter;
import rx.functions.Action1;

public final class InstalledAppsOverviewPresenter extends BasePresenter<InstalledAppsOverviewContract.View> implements InstalledAppsOverviewContract.Presenter {

    @Inject
    GetInstalledAppsUseCase getInstalledAppsUseCase;

    public InstalledAppsOverviewPresenter(final InstalledAppsOverviewContract.View view) {
        super(view);
    }

    @Override
    public void start() {
        super.start();
        getScreenData();
    }

    private void getScreenData() {
        viewActionQueue.subscribeTo(getInstalledAppsUseCase.execute()
                                                           .map(this::convertToViewModel)
                                                           .map(this::mapToViewAction)
                                                           .subscribeOn(backgroundScheduler),
                                    this::processGetInstalledAppsError);
    }

    private InstalledAppsOverviewContract.ViewModel convertToViewModel(final List<AppInformation> appInformationList) {
        return new InstalledAppsOverviewContract.ViewModel(convertToInstalledAppsViewModels(appInformationList));
    }

    private List<InstalledAppsOverviewContract.InstalledAppViewModel> convertToInstalledAppsViewModels(final List<AppInformation> appInformationList) {
        return Stream.of(appInformationList)
                     .map(this::convertToInstalledAppViewModel)
                     .toList();
    }

    private InstalledAppsOverviewContract.InstalledAppViewModel convertToInstalledAppViewModel(final AppInformation appInformation) {
        return new InstalledAppsOverviewContract.InstalledAppViewModel(appInformation.appIdentifier, appInformation.name);
    }

    private Action1<InstalledAppsOverviewContract.View> mapToViewAction(final InstalledAppsOverviewContract.ViewModel viewModel) {
        return view -> view.render(viewModel);
    }

    private void processGetInstalledAppsError(final Throwable throwable) {
        logError(throwable);
    }
}
