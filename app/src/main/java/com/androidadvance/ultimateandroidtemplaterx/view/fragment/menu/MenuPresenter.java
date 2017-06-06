package com.androidadvance.ultimateandroidtemplaterx.view.fragment.menu;

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

public class MenuPresenter implements Presenter<MenuMvpView> {

  private MenuMvpView menuMvpView;

  @Inject public MenuPresenter(Context ctx) {
    ((BaseApplication) ctx.getApplicationContext()).getComponent().inject(this);
  }

  @Inject @Named("cached") APIService apiService;

  @Override public void attachView(MenuMvpView view) {
    this.menuMvpView = view;
  }

  @Override public void detachView() {
    this.menuMvpView = null;
  }

  public void show_headers() {

    apiService.getHeaders().enqueue(new Callback<IPInfo>() {
      @Override public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {
        menuMvpView.showHeaders(response.body().toString());
      }

      @Override public void onFailure(Call<IPInfo> call, Throwable t) {
        menuMvpView.showError(t.getMessage());
      }
    });

  }
}