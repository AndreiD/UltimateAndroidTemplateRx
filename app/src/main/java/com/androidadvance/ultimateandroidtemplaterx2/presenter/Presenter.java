package com.androidadvance.ultimateandroidtemplaterx2.presenter;


public interface Presenter<V> {

    void attachView(V mvpView);

    void detachView();

}