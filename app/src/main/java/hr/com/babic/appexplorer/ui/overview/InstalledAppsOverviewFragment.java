package hr.com.babic.appexplorer.ui.overview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hr.babic.domain.model.AppIdentifier;

import javax.inject.Inject;

import butterknife.BindView;
import hr.com.babic.appexplorer.R;
import hr.com.babic.appexplorer.base.BaseFragment;
import hr.com.babic.appexplorer.base.ScopedPresenter;
import hr.com.babic.appexplorer.injection.fragment.FragmentComponent;

public final class InstalledAppsOverviewFragment extends BaseFragment implements InstalledAppsOverviewContract.View,
                                                                                 InstalledAppsAdapter.InstalledAppsAdapterListener {

    public static final String TAG = "InstalledAppsOverviewFragment";

    @BindView(R.id.fragment_installed_apps_recycler_view)
    RecyclerView recyclerView;

    @Inject
    InstalledAppsOverviewContract.Presenter presenter;

    @Inject
    InstalledAppsAdapter installedAppsAdapter;

    public static InstalledAppsOverviewFragment newInstance() {
        return new InstalledAppsOverviewFragment();
    }

    @Override
    protected void inject(final FragmentComponent component) {
        component.inject(this);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerview();
        installedAppsAdapter.setListener(this);
    }

    private void initRecyclerview() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(installedAppsAdapter);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_installed_apps_overview;
    }

    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void render(final InstalledAppsOverviewContract.ViewModel viewModel) {
        installedAppsAdapter.setItems(viewModel.viewModels);
    }

    @Override
    public void onItemClicked(final AppIdentifier appIdentifier) {
        presenter.showAppDetails(appIdentifier);
    }
}
