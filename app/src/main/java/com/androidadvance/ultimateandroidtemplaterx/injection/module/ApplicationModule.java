package com.androidadvance.ultimateandroidtemplaterx.injection.module;

import android.app.Application;
import com.androidadvance.ultimateandroidtemplaterx.data.DataManager;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return new DataManager(mApplication);
    }

    @Provides
    @Singleton EventBus provideEventBus() {
        return new EventBus();
    }

}