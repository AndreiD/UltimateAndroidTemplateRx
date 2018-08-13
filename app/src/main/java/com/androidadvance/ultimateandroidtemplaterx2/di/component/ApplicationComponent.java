package com.androidadvance.ultimateandroidtemplaterx2.di.component;

import android.app.Application;
import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx2.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx2.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx2.di.ApplicationContext;
import com.androidadvance.ultimateandroidtemplaterx2.di.module.ApplicationModule;
import com.androidadvance.ultimateandroidtemplaterx2.view.fragment.placeholder.PlaceholderPresenter;
import com.androidadvance.ultimateandroidtemplaterx2.view.fragment.status.StatusPresenter;
import dagger.Component;
import javax.inject.Named;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

  void inject(StatusPresenter statusPresenter);

  void inject(PlaceholderPresenter placeholderPresenter);

  @ApplicationContext Context context();

  Application application();

  @Named("cached") APIService apiService();

  @Named("non_cached") APIService apiServiceNonCached();

  EventBus eventBus();

  PreferencesHelper prefsHelper();

}