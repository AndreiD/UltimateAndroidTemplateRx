package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.presenter.Presenter;
import com.socks.library.KLog;
import javax.inject.Inject;


public class DetailPresenter implements Presenter<DetailMvpView> {

  private DetailMvpView detailMvpView;
  private Forecast forecast;

  @Inject public DetailPresenter(Context ctx) {
    ((BaseApplication) ctx.getApplicationContext()).getApplicationComponent().inject(this);
  }

  @Inject APIService apiService;


  @Override public void attachView(DetailMvpView view) {
    this.detailMvpView = view;
  }

  @Override public void detachView() {
    this.detailMvpView = null;
  }

  public void loadForcast(String from_where) {
    String weather_from_where = from_where.trim();
    if (weather_from_where.isEmpty()) return;


    BaseApplication baseApplication = BaseApplication.get(detailMvpView.getContext());



  }
}