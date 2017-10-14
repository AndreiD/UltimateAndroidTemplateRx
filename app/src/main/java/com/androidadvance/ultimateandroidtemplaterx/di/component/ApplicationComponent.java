package com.androidadvance.ultimateandroidtemplaterx.di.component;

import android.app.Application;
import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.data.local.DatabaseService;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.di.ApplicationContext;
import com.androidadvance.ultimateandroidtemplaterx.di.module.ApplicationModule;
import com.androidadvance.ultimateandroidtemplaterx.model.User;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.menu.MenuPresenter;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.placeholder.PlaceholderPresenter;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.status.StatusPresenter;
import dagger.Component;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import javax.inject.Named;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

  void inject(MenuPresenter menuPresenter);

  void inject(StatusPresenter statusPresenter);

  void inject(PlaceholderPresenter placeholderPresenter);

  @ApplicationContext Context context();

  Application application();

  @Named("cached") APIService apiService();

  BoxStore databaseService();

  Box<User> userBox();

  @Named("non_cached") APIService apiServiceNonCached();

  EventBus eventBus();

  PreferencesHelper prefsHelper();

}