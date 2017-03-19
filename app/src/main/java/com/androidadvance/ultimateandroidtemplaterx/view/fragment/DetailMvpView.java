package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import com.androidadvance.ultimateandroidtemplaterx.view.MvpView;

public interface DetailMvpView extends MvpView {
  void showHeaders(String headers);
  void showError(String error);
}