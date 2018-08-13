package com.androidadvance.ultimateandroidtemplaterx2.di.module;

import android.app.Activity;
import android.content.Context;

import com.androidadvance.ultimateandroidtemplaterx2.di.ActivityContext;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
  private final Activity mActivity;

  public ActivityModule(Activity activity) {
    mActivity = activity;
  }

  @Provides
  Activity provideActivity() {
    return mActivity;
  }

  @Provides
  @ActivityContext
  Context providesContext() {
    return mActivity;
  }
}