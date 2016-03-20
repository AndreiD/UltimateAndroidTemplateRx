package com.androidadvance.ultimateandroidtemplaterx.di.component;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.UnauthorisedInterceptor;
import com.androidadvance.ultimateandroidtemplaterx.di.module.ApplicationModule;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.DetailPresenter;
import com.androidadvance.ultimateandroidtemplaterx.view.main.MainPresenter;
import dagger.Component;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

  void inject(MainPresenter mainPresenter);
  void inject(DetailPresenter detailPresenter);

  void inject(BaseApplication baseApplication);
  void inject(UnauthorisedInterceptor unauthorisedInterceptor);

  APIService apiService();
  EventBus eventBus();
  PreferencesHelper prefsHelper();


}