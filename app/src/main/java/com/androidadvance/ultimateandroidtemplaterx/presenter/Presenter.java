package com.androidadvance.ultimateandroidtemplaterx.presenter;

public interface Presenter<V> {

  void attachView(V mvpView);

  void detachView();

}
