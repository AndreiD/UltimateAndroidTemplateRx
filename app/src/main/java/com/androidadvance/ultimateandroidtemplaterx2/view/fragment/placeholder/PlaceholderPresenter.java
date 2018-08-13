package com.androidadvance.ultimateandroidtemplaterx2.view.fragment.placeholder;

import android.content.Context;
import android.support.annotation.NonNull;

import com.androidadvance.ultimateandroidtemplaterx2.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx2.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx2.model.IPInfo;
import com.androidadvance.ultimateandroidtemplaterx2.presenter.Presenter;
import com.socks.library.KLog;
import java.security.Key;
import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceholderPresenter implements Presenter<PlaceholderMvpView> {

  private PlaceholderMvpView placeholderMvpView;

  @Inject public PlaceholderPresenter(Context ctx) {
    ((BaseApplication) ctx.getApplicationContext()).getComponent().inject(this);
  }

  @Inject @Named("cached") APIService apiService;

  @Override public void attachView(PlaceholderMvpView view) {
    this.placeholderMvpView = view;
  }

  @Override public void detachView() {
    this.placeholderMvpView = null;
  }

  public void show_headers() {

    apiService.getHeaders().enqueue(new Callback<IPInfo>() {
      @Override public void onResponse(@NonNull Call<IPInfo> call, @NonNull Response<IPInfo> response) {

        placeholderMvpView.showHeaders(response.body().toString());
      }

      @Override public void onFailure(@NonNull Call<IPInfo> call, @NonNull Throwable t) {
        KLog.e(t);
        placeholderMvpView.showError("error");
      }
    });

  }
}