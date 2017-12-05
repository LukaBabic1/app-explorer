package hr.com.babic.appexplorer.injection.fragment.module;

import dagger.Module;
import hr.com.babic.appexplorer.injection.fragment.DaggerFragment;

@Module
public final class FragmentPresenterModule {

    private final DaggerFragment fragment;

    public FragmentPresenterModule(final DaggerFragment fragment) {
        this.fragment = fragment;
    }

    public interface Exposes {

    }
}
