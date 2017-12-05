package hr.com.babic.appexplorer.ui.appdetails;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.com.babic.appexplorer.R;

public final class AppActivitiesAdapter extends RecyclerView.Adapter<AppActivitiesAdapter.ViewHolder> {

    public interface Listener {

    }

    private final LayoutInflater inflater;

    private final List<AppDetailsContract.AppActivityViewModel> items = new ArrayList<>();

    public AppActivitiesAdapter(final LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.adapter_app_activity_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.populate(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(final List<AppDetailsContract.AppActivityViewModel> viewModels) {
        items.clear();
        items.addAll(viewModels);

        notifyDataSetChanged();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.adapter_app_details_row_item_app_title)
        TextView activityName;

        public ViewHolder(final View itemView) {
            super(itemView);
            bindViews(itemView);
        }

        private void bindViews(final View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void populate(final AppDetailsContract.AppActivityViewModel viewModel) {
            activityName.setText(viewModel.name);
        }

        @OnClick(R.id.adapter_app_details_row_item_root_view)
        void onRowItemClicked() {
            // TODO
        }
    }
}
