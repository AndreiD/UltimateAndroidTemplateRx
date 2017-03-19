package com.androidadvance.ultimateandroidtemplaterx.view.main;

import com.androidadvance.ultimateandroidtemplaterx.presenter.Presenter;


public class MainPresenter implements Presenter<MainMvpView> {

  private MainMvpView mainMvpView;

  @Override public void attachView(MainMvpView view) {
    this.mainMvpView = view;
  }

  @Override public void detachView() {
    this.mainMvpView = null;
  }

}