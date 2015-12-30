package com.androidadvance.ultimateandroidtemplaterx.view.main;

import com.androidadvance.ultimateandroidtemplaterx.model.weather.WeatherPojo;
import com.androidadvance.ultimateandroidtemplaterx.view.MvpView;

public interface MainMvpView extends MvpView {

  void showWeather(WeatherPojo weatherPojo);

  void showMessage(int stringId);

  void showProgress();

  void hideProgress();
}