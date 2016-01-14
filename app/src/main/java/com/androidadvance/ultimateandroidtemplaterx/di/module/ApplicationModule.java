package com.androidadvance.ultimateandroidtemplaterx.di.module;

import android.database.sqlite.SQLiteDatabase;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.local.WeatherDatabase;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.raizlabs.android.dbflow.config.FlowManager;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

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

  @Provides @Singleton public SQLiteDatabase database() {
    return FlowManager.getDatabase(WeatherDatabase.NAME).getWritableDatabase();
  }




}