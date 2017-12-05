package hr.com.babic.appexplorer.ui.appdetails;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.hr.babic.domain.model.AppIdentifier;

import javax.inject.Inject;

import hr.com.babic.appexplorer.R;
import hr.com.babic.appexplorer.base.BaseFragment;
import hr.com.babic.appexplorer.base.ScopedPresenter;
import hr.com.babic.appexplorer.injection.fragment.FragmentComponent;

public final class AppDetailsFragment extends BaseFragment implements AppDetailsContract.View {

    public static final String TAG = "AppDetailsFragment";

    private static final String KEY_BUNDLE_EXTRA = "key_bundle_extra";

    @Inject
    AppDetailsContract.Presenter presenter;

    public static AppDetailsFragment newInstance(final AppIdentifier appIdentifier) {
        final Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BUNDLE_EXTRA, new Request(appIdentifier));

        final AppDetailsFragment fragment = new AppDetailsFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected void inject(final FragmentComponent component) {
        component.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_app_details;
    }

    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    public static final class Request implements Parcelable {

        public final AppIdentifier appIdentifier;

        public Request(final AppIdentifier appIdentifier) {
            this.appIdentifier = appIdentifier;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeSerializable(this.appIdentifier);
        }

        protected Request(Parcel in) {
            this.appIdentifier = (AppIdentifier) in.readSerializable();
        }

        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() {
            @Override
            public Request createFromParcel(Parcel source) {
                return new Request(source);
            }

            @Override
            public Request[] newArray(int size) {
                return new Request[size];
            }
        };
    }
}
