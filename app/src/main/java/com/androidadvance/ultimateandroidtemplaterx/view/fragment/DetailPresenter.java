package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.presenter.Presenter;
import com.socks.library.KLog;
import javax.inject.Inject;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;


public class DetailPresenter implements Presenter<DetailMvpView> {

  private DetailMvpView detailMvpView;
  private Subscription subscription;
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
    if (subscription != null) subscription.unsubscribe();
  }

  public void loadForcast(String from_where) {
    String weather_from_where = from_where.trim();
    if (weather_from_where.isEmpty()) return;

    if (subscription != null) subscription.unsubscribe();

    BaseApplication baseApplication = BaseApplication.get(detailMvpView.getContext());


    subscription = apiService.getForecastForCity(weather_from_where, "metric", 7)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(baseApplication.getSubscribeScheduler())
        .subscribe(new Subscriber<Forecast>() {
          @Override public void onCompleted() {
            KLog.i("Forcast loaded %s", forecast);
            detailMvpView.showForecast(forecast);
          }

          @Override public void onError(Throwable error) {
            KLog.e("Error loading forecast %s", error);
          }

          @Override public void onNext(Forecast forecast) {
            DetailPresenter.this.forecast = forecast;
          }
        });
  }
}