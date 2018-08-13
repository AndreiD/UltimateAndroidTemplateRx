package com.androidadvance.ultimateandroidtemplaterx2.view.main;

import com.androidadvance.ultimateandroidtemplaterx2.presenter.Presenter;


public class MainPresenter implements Presenter<MainMvpView> {

    private MainMvpView mainMvpView;

    @Override
    public void attachView(MainMvpView view) {
        this.mainMvpView = view;
    }

    @Override
    public void detachView() {
        this.mainMvpView = null;
    }


    public void do_stuff() {
        //doing stuff here...
        mainMvpView.doing_nothing();
    }
}