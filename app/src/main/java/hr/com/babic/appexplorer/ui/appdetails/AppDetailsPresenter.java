package hr.com.babic.appexplorer.ui.appdetails;

import com.annimon.stream.Stream;
import com.hr.babic.domain.interactor.GetActivitiesForApplicationUseCase;
import com.hr.babic.domain.model.ActivityInformation;
import com.hr.babic.domain.model.AppIdentifier;

import java.util.List;

import javax.inject.Inject;

import hr.com.babic.appexplorer.base.BasePresenter;
import rx.functions.Action1;

public final class AppDetailsPresenter extends BasePresenter<AppDetailsContract.View> implements AppDetailsContract.Presenter {

    @Inject
    GetActivitiesForApplicationUseCase getActivitiesForApplicationUseCase;

    public AppDetailsPresenter(final AppDetailsContract.View view) {
        super(view);
    }

    @Override
    public void init(final AppIdentifier appIdentifier) {
        viewActionQueue.subscribeTo(getActivitiesForApplicationUseCase.execute(appIdentifier)
                                                                      .map(this::toAppActivityViewModels)
                                                                      .map(this::mapToViewAction),
                                    this::processGetActivitiesForApplicationError);
    }

    private List<AppDetailsContract.AppActivityViewModel> toAppActivityViewModels(final List<ActivityInformation> activityInformationList) {
        return Stream.of(activityInformationList)
                     .map(this::toAppActivityViewModel)
                     .toList();
    }

    private AppDetailsContract.AppActivityViewModel toAppActivityViewModel(final ActivityInformation activityInformation) {
        return new AppDetailsContract.AppActivityViewModel(activityInformation.name);
    }

    private Action1<AppDetailsContract.View> mapToViewAction(final List<AppDetailsContract.AppActivityViewModel> viewModels) {
        return view -> view.render(new AppDetailsContract.ViewModel(viewModels));
    }

    private void processGetActivitiesForApplicationError(final Throwable throwable) {
        logError(throwable);
    }
}
