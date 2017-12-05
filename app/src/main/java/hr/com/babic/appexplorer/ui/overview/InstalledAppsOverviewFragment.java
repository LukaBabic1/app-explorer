package hr.com.babic.appexplorer.ui.overview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import hr.com.babic.appexplorer.R;
import hr.com.babic.appexplorer.base.BaseFragment;
import hr.com.babic.appexplorer.base.ScopedPresenter;
import hr.com.babic.appexplorer.injection.fragment.FragmentComponent;

public final class InstalledAppsOverviewFragment extends BaseFragment implements InstalledAppsOverviewContract.View {

    public static final String TAG = "InstalledAppsOverviewFragment";

    @BindView(R.id.fragment_installed_apps_recycler_view)
    RecyclerView recyclerView;

    @Inject
    InstalledAppsOverviewContract.Presenter presenter;

    @Inject
    InstalledAppsAdapter adapter;

    public static InstalledAppsOverviewFragment newInstance() {
        return new InstalledAppsOverviewFragment();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void inject(final FragmentComponent component) {
        component.inject(this);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerview();
    }

    private void initRecyclerview() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
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
        adapter.setItems(viewModel.viewModels);
    }
}
