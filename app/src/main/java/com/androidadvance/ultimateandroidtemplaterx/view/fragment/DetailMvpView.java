package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.view.MvpView;

public interface DetailMvpView extends MvpView {
  void showForecast(Forecast forecast);
}