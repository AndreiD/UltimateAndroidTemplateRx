package com.androidadvance.ultimateandroidtemplaterx.di.module;

import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Module public class ApplicationModule {

  private final BaseApplication baseApplicaton;

  public ApplicationModule(BaseApplication baseApplication) {
    this.baseApplicaton = baseApplication;
  }

  @Provides @Singleton public BaseApplication provideApplication() {

    return baseApplicaton;
  }

  @Provides @Singleton public APIService provideApiService() {

    return APIService.Factory.create(baseApplicaton);
  }

  @Provides @Singleton public EventBus eventBus() {

    return new EventBus();
  }

  @Provides @Singleton public PreferencesHelper prefsHelper() {

    return new PreferencesHelper(baseApplicaton);
  }

  @Provides @Singleton public Context provideContext() {
    return baseApplicaton;
  }
}