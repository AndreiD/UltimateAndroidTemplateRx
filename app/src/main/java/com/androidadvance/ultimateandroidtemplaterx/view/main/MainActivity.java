package com.androidadvance.ultimateandroidtemplaterx.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.events.MessagesEvent;
import com.androidadvance.ultimateandroidtemplaterx.model.weather.WeatherPojo;
import com.androidadvance.ultimateandroidtemplaterx.util.DialogFactory;
import com.androidadvance.ultimateandroidtemplaterx.util.UnitLocale;
import com.androidadvance.ultimateandroidtemplaterx.view.BaseActivity;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.DetailFragment;
import com.androidadvance.ultimateandroidtemplaterx.view.settings.SettingsActivity;
import de.greenrobot.event.EventBus;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainMvpView {

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.textview_main_city) TextView textview_main_city;
  @Bind(R.id.textView_main_conditions) TextView textView_main_conditions;
  @Bind(R.id.textView_main_current_temperature) TextView textView_main_current_temperature;
  @Bind(R.id.textView_main_min_max) TextView textView_main_min_max;
  @Bind(R.id.textView_main_pressure) TextView textView_main_pressure;
  @Bind(R.id.textView_main_humidity) TextView textView_main_humidity;
  @Bind(R.id.textView_main_wind) TextView textView_main_wind;
  @Bind(R.id.imageView_main_icon) ImageView imageView_main_icon;
  @Bind(R.id.button_main_next_days) Button button_main_next_days;
  private static ProgressBar mProgressBar = null;
  private MainPresenter presenter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    presenter = new MainPresenter();
    presenter.attachView(this);

    setSupportActionBar(toolbar);

    getSupportFragmentManager().addOnBackStackChangedListener(() -> {
      if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      } else {
        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
      }
    });

    presenter.loadWeather("Sofia,bg");
  }

  @OnClick(R.id.button_main_next_days) void onClick_button_main_next_days() {
    getSupportActionBar().setTitle("Next days");
    getSupportFragmentManager().beginTransaction().replace(R.id.container_rellayout, DetailFragment.newInstance(1)).addToBackStack(null).commit();
  }

  @Override protected void onDestroy() {
    presenter.detachView();
    super.onDestroy();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.action_settings:
        startActivity(new Intent(this, SettingsActivity.class));
        return true;
      case R.id.action_exit:
        finish();
        return true;
      case R.id.action_refresh:

        if(getFragmentManager().getBackStackEntryCount()>0){
          //--- we are in the details fragment.

        }else{
          //--- we are here
          presenter.loadWeather("Sofia,bg");
        }

        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override public void onStart() {
    super.onStart();
    EventBus.getDefault().register(this);
  }

  @Override public void onStop() {
    EventBus.getDefault().unregister(this);
    super.onStop();
  }

  public void onEvent(MessagesEvent event) {

    if (event.ismSuccess()) {
      DialogFactory.createSimpleOkDialog(MainActivity.this, getString(R.string.app_name), event.getMessage()).show();
    } else {
      DialogFactory.showErrorSnackBar(MainActivity.this, findViewById(android.R.id.content), new Throwable(event.getMessage())).show();
    }
  }

  @Override public void showWeather(WeatherPojo weatherPojo) {

    Timber.d("show Weather %s", weatherPojo.toString());

    textview_main_city.setText(weatherPojo.getName());
    textView_main_current_temperature.setText(String.format("%.1f°", weatherPojo.getMain().getTemp()));
    textView_main_min_max.setText(String.format("%.1f°  %.1f°", weatherPojo.getMain().getTempMin(), weatherPojo.getMain().getTempMax()));
    textView_main_conditions.setText(weatherPojo.getWeather().get(0).getDescription());
    textView_main_humidity.setText(getString(R.string.humidity) + " " + weatherPojo.getMain().getHumidity() + "%");

    String wind_suffix = getResources().getString(R.string.wind_suffix_metric);
    if (UnitLocale.getDefault().equals(UnitLocale.Imperial)) wind_suffix = getResources().getString(R.string.wind_suffix_imperial);
    textView_main_wind.setText(getString(R.string.wind) + " " + String.valueOf(weatherPojo.getWind().getSpeed()) + wind_suffix);

    textView_main_pressure.setText(getString(R.string.pressure) + " " + weatherPojo.getMain().getPressure() + "hPa");
    imageView_main_icon.setImageDrawable(ContextCompat.getDrawable(getContext(), getIcon(weatherPojo.getWeather().get(0).getId())));
  }

  @Override public void showProgress() {
    if (mProgressBar == null) {
      mProgressBar = DialogFactory.DProgressBar(MainActivity.this);
    } else {
      mProgressBar.setVisibility(View.VISIBLE);
    }
  }

  @Override public void hideProgress() {
    mProgressBar.setVisibility(View.GONE);
  }

  @Override public Context getContext() {
    return this;
  }

  //http://openweathermap.org/weather-conditions
  public static int getIcon(int weatherId) {
    if (weatherId >= 200 && weatherId <= 232) {
      return R.drawable.ic_thunderstorm;
    } else if (weatherId >= 300 && weatherId <= 321) {
      return R.drawable.ic_rain;
    } else if (weatherId >= 500 && weatherId <= 504) {
      return R.drawable.ic_rain;
    } else if (weatherId == 511) {
      return R.drawable.ic_snow;
    } else if (weatherId >= 520 && weatherId <= 531) {
      return R.drawable.ic_rain;
    } else if (weatherId >= 600 && weatherId <= 622) {
      return R.drawable.ic_snow;
    } else if (weatherId >= 701 && weatherId <= 761) {
      return R.drawable.ic_fog;
    } else if (weatherId == 761 || weatherId == 781) {
      return R.drawable.ic_thunderstorm;
    } else if (weatherId == 800) {
      return R.drawable.ic_clear;
    } else if (weatherId == 801) {
      return R.drawable.ic_light_clouds;
    } else if (weatherId >= 802 && weatherId <= 804) {
      return R.drawable.ic_cloudy;
    }
    return -1;
  }
}
