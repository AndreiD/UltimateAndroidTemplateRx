package com.androidadvance.ultimateandroidtemplaterx2.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;

import com.androidadvance.ultimateandroidtemplaterx2.R;
import com.androidadvance.ultimateandroidtemplaterx2.events.MessagesEvent;
import com.androidadvance.ultimateandroidtemplaterx2.util.DialogFactory;
import com.androidadvance.ultimateandroidtemplaterx2.view.BaseActivity;
import com.androidadvance.ultimateandroidtemplaterx2.view.fragment.status.StatusFragment;
import com.androidadvance.ultimateandroidtemplaterx2.view.settings.SettingsActivity;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    private MainPresenter presenter;

    @Inject
    EventBus eventBus;
    private MainActivity mContext;

    @BindView(R.id.fab)
    FloatingActionButton fab;

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


    }


    @OnClick(R.id.fab)
    void onClick_show_headers() {
        presenter.do_stuff();
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, StatusFragment.newInstance()).commit();
    }

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
        KLog.d("doing noting......");
    }
}
