package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.model.IPInfo;
import com.androidadvance.ultimateandroidtemplaterx.presenter.Presenter;

import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements Presenter<DetailMvpView> {

  private DetailMvpView detailMvpView;

  @Inject public DetailPresenter(Context ctx) {
    ((BaseApplication) ctx.getApplicationContext()).getComponent().inject(this);
  }

  @Inject @Named("cached") APIService apiService;

  @Override public void attachView(DetailMvpView view) {
    this.detailMvpView = view;
  }

  @Override public void detachView() {
    this.detailMvpView = null;
  }

  public void show_headers() {

    apiService.getHeaders().enqueue(new Callback<IPInfo>() {
      @Override public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {
        detailMvpView.showHeaders(response.body().toString());
      }

      @Override public void onFailure(Call<IPInfo> call, Throwable t) {
        detailMvpView.showError(t.getLocalizedMessage());
      }
    });

  }
}