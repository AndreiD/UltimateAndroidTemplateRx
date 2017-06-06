package com.androidadvance.ultimateandroidtemplaterx.view.fragment.placeholder;

import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.model.IPInfo;
import com.androidadvance.ultimateandroidtemplaterx.presenter.Presenter;
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
      @Override public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {

        placeholderMvpView.showHeaders(response.body().toString());
      }

      @Override public void onFailure(Call<IPInfo> call, Throwable t) {
        KLog.e(t);
        placeholderMvpView.showError("error");
      }
    });

  }
}