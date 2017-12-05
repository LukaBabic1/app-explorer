package hr.com.babic.appexplorer.ui.overview;

import com.annimon.stream.Stream;
import com.hr.babic.domain.interactor.GetInstalledAppsUseCase;
import com.hr.babic.domain.model.AppIdentifier;
import com.hr.babic.domain.model.AppInformation;
import com.hr.babic.domain.util.ListUtils;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import hr.com.babic.appexplorer.base.BasePresenter;
import rx.functions.Action1;

public final class InstalledAppsOverviewPresenter extends BasePresenter<InstalledAppsOverviewContract.View> implements InstalledAppsOverviewContract.Presenter {

    private static final Comparator<AppInformation> APP_INFORMATION_COMPARATOR = (o1, o2) -> o1.name.compareToIgnoreCase(o2.name);

    @Inject
    GetInstalledAppsUseCase getInstalledAppsUseCase;

    @Inject
    ListUtils listUtils;

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
                                                           .map(this::sortApplicationInformations)
                                                           .map(this::convertToViewModel)
                                                           .map(this::mapToViewAction)
                                                           .subscribeOn(backgroundScheduler),
                                    this::processGetInstalledAppsError);
    }

    private List<AppInformation> sortApplicationInformations(final List<AppInformation> appInformations) {
        return listUtils.sort(appInformations, APP_INFORMATION_COMPARATOR);
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

    @Override
    public void showAppDetails(final AppIdentifier appIdentifier) {
        router.showAppDetails(appIdentifier);
    }
}
