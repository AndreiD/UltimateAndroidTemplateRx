package com.androidadvance.ultimateandroidtemplaterx2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.androidadvance.ultimateandroidtemplaterx2.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx2.di.component.ActivityComponent;
import com.androidadvance.ultimateandroidtemplaterx2.di.component.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {

  private ActivityComponent mActivityComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    mActivityComponent = DaggerActivityComponent.builder()
        .applicationComponent(getApp().getComponent())
        .build();
  }

  public ActivityComponent getActivityComponent() {
    return mActivityComponent;
  }

  protected BaseApplication getApp() {
    return (BaseApplication) getApplicationContext();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override public void onBackPressed() {
    if (getFragmentManager().getBackStackEntryCount() > 0) {
      getFragmentManager().popBackStack();
    } else {
      super.onBackPressed();
    }
  }
}
