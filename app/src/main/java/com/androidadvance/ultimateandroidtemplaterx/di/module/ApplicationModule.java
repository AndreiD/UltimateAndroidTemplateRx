package com.androidadvance.ultimateandroidtemplaterx.di.module;

import android.content.Context;
import android.app.Application;
import com.androidadvance.ultimateandroidtemplaterx.data.local.DatabaseService;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.di.ApplicationContext;
import com.androidadvance.ultimateandroidtemplaterx.model.User;
import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;
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

  @Provides @Singleton public BoxStore provideDatabaseService() {
    return DatabaseService.Factory.create(mApplication);
  }

  @Provides @Singleton public Box<User> providesUserBox() {
    return provideDatabaseService().boxFor(User.class);
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