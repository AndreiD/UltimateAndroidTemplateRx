package com.androidadvance.ultimateandroidtemplaterx.view.fragment.status;

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

public class StatusPresenter implements Presenter<StatusMvpView> {

  private StatusMvpView statusMvpView;

  @Inject public StatusPresenter(Context ctx) {
    ((BaseApplication) ctx.getApplicationContext()).getComponent().inject(this);
  }

  @Inject @Named("cached") APIService apiService;

  @Override public void attachView(StatusMvpView view) {
    this.statusMvpView = view;
  }

  @Override public void detachView() {
    this.statusMvpView = null;
  }

  public void show_headers() {

    apiService.getHeaders().enqueue(new Callback<IPInfo>() {
      @Override public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {
        statusMvpView.showHeaders(response.body().toString());
      }

      @Override public void onFailure(Call<IPInfo> call, Throwable t) {
        statusMvpView.showError(t.getMessage());
      }
    });

  }
}