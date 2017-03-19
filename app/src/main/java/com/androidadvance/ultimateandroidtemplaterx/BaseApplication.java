package com.androidadvance.ultimateandroidtemplaterx;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.androidadvance.ultimateandroidtemplaterx.di.component.ApplicationComponent;
import com.androidadvance.ultimateandroidtemplaterx.di.component.DaggerApplicationComponent;
import com.androidadvance.ultimateandroidtemplaterx.di.module.ApplicationModule;
import com.socks.library.KLog;

public class BaseApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();

    boolean isDebuggable = (0 != (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));

    if (isDebuggable) {
      KLog.init(true);
    } else {
      KLog.init(false);
    }
  }

  public static BaseApplication get(Context context) {
    return (BaseApplication) context.getApplicationContext();
  }

  public ApplicationComponent getComponent() {
    if (mApplicationComponent == null) {
      mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
    return mApplicationComponent;
  }


  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }

  @Override public void onLowMemory() {
    super.onLowMemory();
    KLog.e("########## onLowMemory ##########");
  }
}
