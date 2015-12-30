package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.ApiService;
import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.presenter.Presenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

public class DetailPresenter implements Presenter<DetailMvpView> {

  private DetailMvpView detailMvpView;
  private Subscription subscription;
  private Forecast forecast;

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
    ApiService apiService = baseApplication.getApiService();

    subscription = apiService.getForecastForCity(weather_from_where, "metric")
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(baseApplication.defaultSubscribeScheduler())
        .subscribe(new Subscriber<Forecast>() {
          @Override public void onCompleted() {
            Timber.i("Forcast loaded %s", forecast);
            detailMvpView.showForecast(forecast);
          }

          @Override public void onError(Throwable error) {
            Timber.e("Error loading forecast %s", error);
          }

          @Override public void onNext(Forecast forecast) {
            DetailPresenter.this.forecast = forecast;
          }
        });
  }
}