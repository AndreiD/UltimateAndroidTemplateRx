package com.androidadvance.ultimateandroidtemplaterx.injection.module;

import android.app.Application;
import android.content.Context;


import com.androidadvance.ultimateandroidtemplaterx.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton EventBus provideEventBus() {
        return new EventBus();
    }



}