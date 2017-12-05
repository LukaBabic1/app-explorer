package hr.com.babic.appexplorer.ui.overview;

import com.annimon.stream.Stream;
import com.hr.babic.domain.interactor.GetInstalledAppsUseCase;
import com.hr.babic.domain.model.AppIdentifier;
import com.hr.babic.domain.model.ApplicationInformation;
import com.hr.babic.domain.util.ListUtils;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import hr.com.babic.appexplorer.base.BasePresenter;
import rx.functions.Action1;

public final class InstalledAppsOverviewPresenter extends BasePresenter<InstalledAppsOverviewContract.View> implements InstalledAppsOverviewContract.Presenter {

    private static final Comparator<ApplicationInformation> APP_INFORMATION_COMPARATOR = (o1, o2) -> o1.name.compareToIgnoreCase(o2.name);

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

    private List<ApplicationInformation> sortApplicationInformations(final List<ApplicationInformation> applicationInformations) {
        return listUtils.sort(applicationInformations, APP_INFORMATION_COMPARATOR);
    }

    private InstalledAppsOverviewContract.ViewModel convertToViewModel(final List<ApplicationInformation> applicationInformationList) {
        return new InstalledAppsOverviewContract.ViewModel(convertToInstalledAppsViewModels(applicationInformationList));
    }

    private List<InstalledAppsOverviewContract.InstalledAppViewModel> convertToInstalledAppsViewModels(final List<ApplicationInformation> applicationInformationList) {
        return Stream.of(applicationInformationList)
                     .map(this::convertToInstalledAppViewModel)
                     .toList();
    }

    private InstalledAppsOverviewContract.InstalledAppViewModel convertToInstalledAppViewModel(final ApplicationInformation applicationInformation) {
        return new InstalledAppsOverviewContract.InstalledAppViewModel(applicationInformation.appIdentifier, applicationInformation.name);
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
