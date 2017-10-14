package com.androidadvance.ultimateandroidtemplaterx.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.events.MessagesEvent;
import com.androidadvance.ultimateandroidtemplaterx.util.DialogFactory;
import com.androidadvance.ultimateandroidtemplaterx.util.adaptablebottomnavigation.view.AdaptableBottomNavigationView;
import com.androidadvance.ultimateandroidtemplaterx.util.adaptablebottomnavigation.view.ViewSwapper;
import com.androidadvance.ultimateandroidtemplaterx.view.BaseActivity;
import com.androidadvance.ultimateandroidtemplaterx.view.settings.SettingsActivity;
import com.socks.library.KLog;
import java.util.Arrays;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity implements MainMvpView {

  @BindView(R.id.view_bottom_navigation) AdaptableBottomNavigationView adaptableBottomNavigationView;
  @BindView(R.id.view_swapper) ViewSwapper view_swapper;
  private ViewSwapperAdapter viewSwapperAdapter;
  private MainPresenter presenter;

  @Inject EventBus eventBus;
  private MainActivity mContext;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    getActivityComponent().inject(this);
    mContext = MainActivity.this;

    presenter = new MainPresenter();
    presenter.attachView(this);

    getSupportActionBar().setElevation(0);



    //let's test some Java 8 stuff
    String[] stringArray = { "Barbara", "James", "Mary", "John",
        "Patricia", "Robert", "Michael", "Linda" };
    Arrays.sort(stringArray, String::compareToIgnoreCase);
    KLog.d(Arrays.asList(stringArray));


    viewSwapperAdapter = new ViewSwapperAdapter(getSupportFragmentManager());
    view_swapper.setAdapter(viewSwapperAdapter);
    adaptableBottomNavigationView.setupWithViewSwapper(view_swapper);
  }

  //@OnClick(R.id.button_show_headers) void onClick_show_headers() {
  //
  //  getSupportFragmentManager().beginTransaction().replace(android.R.id.content, MenuFragment.newInstance(1)).addToBackStack(null).commit();
  //}

  @Override
  protected void onDestroy() {
    presenter.detachView();
    super.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_settings:
        startActivity(new Intent(this, SettingsActivity.class));
        return true;
      case R.id.action_exit:
        finish();
        return true;
      case R.id.action_refresh:
        DialogFactory.createSimpleOkDialog(mContext, "This is a title", "nothing to refresh").show();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public void onStart() {
    super.onStart();
    eventBus.register(this);
  }

  @Override
  public void onStop() {
    eventBus.unregister(this);
    super.onStop();
  }

  @Subscribe
  public void onEvent(MessagesEvent event) {
    if (event.ismSuccess()) {
      DialogFactory.createSimpleOkDialog(MainActivity.this, getString(R.string.app_name), event.getMessage()).show();
    } else {
      DialogFactory.error_toast(MainActivity.this, event.getMessage()).show();
    }
  }

  @Override
  public void doing_nothing() {
    KLog.d("doing nothign...");
  }
}
