package hr.com.babic.appexplorer.injection.application.module;

import com.hr.babic.domain.util.ListUtils;
import com.hr.babic.domain.util.ListUtilsImpl;
import com.hr.babic.domain.util.StringUtils;
import com.hr.babic.domain.util.StringUtilsImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class UtilsModule {

    @Provides
    @Singleton
    ListUtils provideListUtils() {
        return new ListUtilsImpl();
    }

    @Provides
    @Singleton
    StringUtils provideStringUtils() {
        return new StringUtilsImpl();
    }

    public interface Exposes {

        ListUtils listUtils();

        StringUtils stringUtils();
    }
}
