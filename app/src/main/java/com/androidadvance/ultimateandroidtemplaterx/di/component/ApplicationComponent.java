package com.androidadvance.ultimateandroidtemplaterx.di.component;

import android.app.Application;
import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.di.ApplicationContext;
import com.androidadvance.ultimateandroidtemplaterx.di.module.ApplicationModule;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.DetailPresenter;
import dagger.Component;
import javax.inject.Named;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Singleton @Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

  void inject(DetailPresenter detailPresenter);

  @ApplicationContext Context context();

  Application application();

  @Named("cached") APIService apiService();

  @Named("non_cached") APIService apiServiceNonCached();

  EventBus eventBus();

  PreferencesHelper prefsHelper();
  
  //DatabaseHelper databaseHelper();
}