package com.androidadvance.ultimateandroidtemplaterx.di.module;

import android.content.Context;
import android.app.Application;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Module public class ApplicationModule {

  protected final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides public Application provideApplication() {

    return mApplication;
  }

  @Provides @ApplicationContext public Context provideContext() {
    return mApplication;
  }

  @Provides @Named("cached") @Singleton public APIService provideApiService() {
    return APIService.Factory.create(mApplication, true);
  }

  @Provides @Named("non_cached") @Singleton public APIService provideApiServiceNonCached() {
    return APIService.Factory.create(mApplication, false);
  }

  @Provides @Singleton public EventBus eventBus() {
    return new EventBus();
  }

  @Provides @Singleton public PreferencesHelper prefsHelper() {

    return new PreferencesHelper(mApplication);
  }
}