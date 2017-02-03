package com.androidadvance.ultimateandroidtemplaterx;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.VisibleForTesting;
import com.androidadvance.ultimateandroidtemplaterx.di.component.ApplicationComponent;
import com.androidadvance.ultimateandroidtemplaterx.di.component.DaggerApplicationComponent;
import com.androidadvance.ultimateandroidtemplaterx.di.module.ApplicationModule;
import com.androidadvance.ultimateandroidtemplaterx.events.AuthenticationErrorEvent;
import com.socks.library.KLog;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class BaseApplication extends Application {

  private ApplicationComponent applicationComponent;
  @Inject EventBus eventBus;

  @Override public void onCreate() {
    super.onCreate();

    boolean isDebuggable = (0 != (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));

    if (isDebuggable) {
      KLog.init(true);
    } else {
      KLog.init(false);
    }

    applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

    applicationComponent.inject(this);
    eventBus.register(this);
  }

  public static BaseApplication get(Context context) {
    return (BaseApplication) context.getApplicationContext();
  }



  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  @VisibleForTesting public void setApplicationComponent(ApplicationComponent applicationComponent) {
    applicationComponent = applicationComponent;
  }

  @Override public void onLowMemory() {
    super.onLowMemory();
    KLog.e("########## onLowMemory ##########");
  }

  @Override public void onTerminate() {
    eventBus.unregister(this);
    super.onTerminate();
  }

  @Subscribe public void onEvent(AuthenticationErrorEvent event) {
    KLog.e("Unauthorized! Redirect to Signing Activity..!.");
  }
}
