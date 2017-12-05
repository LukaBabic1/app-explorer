package hr.com.babic.appexplorer.ui.overview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.com.babic.appexplorer.R;

public final class InstalledAppsAdapter extends RecyclerView.Adapter<InstalledAppsAdapter.ViewHolder> {

    private final List<InstalledAppsOverviewContract.InstalledAppViewModel> adapterItems = new ArrayList<>();

    private final LayoutInflater inflater;

    public InstalledAppsAdapter(final LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public InstalledAppsAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.adapter_installed_apps_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final InstalledAppsAdapter.ViewHolder holder, final int position) {
        holder.populate(adapterItems.get(position));
    }

    @Override
    public int getItemCount() {
        return adapterItems.size();
    }

    public void setItems(final List<InstalledAppsOverviewContract.InstalledAppViewModel> viewModels) {
        adapterItems.clear();
        adapterItems.addAll(viewModels);

        notifyDataSetChanged();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.adapter_installed_apps_row_item_app_title)
        TextView appName;

        public ViewHolder(final View itemView) {
            super(itemView);
            bindViews(itemView);
        }

        private void bindViews(final View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void populate(final InstalledAppsOverviewContract.InstalledAppViewModel viewModel) {
            appName.setText(viewModel.appName);
        }
    }
}
