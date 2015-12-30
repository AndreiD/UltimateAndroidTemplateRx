package com.androidadvance.ultimateandroidtemplaterx.events;

import android.support.annotation.Nullable;
import com.androidadvance.ultimateandroidtemplaterx.model.weather.WeatherPojo;

public class FetchWeatherEvent {
  private final boolean mSuccess;

  @Nullable private final WeatherPojo weatherPojo;

  public FetchWeatherEvent(boolean mSuccess, @Nullable WeatherPojo weatherPojo) {
    this.mSuccess = mSuccess;
    this.weatherPojo = weatherPojo;
  }

  public WeatherPojo getWeatherPojo() {
    return weatherPojo;
  }

  public boolean ismSuccess() {
    return mSuccess;
  }
}
