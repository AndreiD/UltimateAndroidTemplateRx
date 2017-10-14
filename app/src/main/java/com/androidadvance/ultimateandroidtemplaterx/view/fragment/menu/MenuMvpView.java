package com.androidadvance.ultimateandroidtemplaterx.view.fragment.menu;

import com.androidadvance.ultimateandroidtemplaterx.view.MvpView;

public interface MenuMvpView extends MvpView {
  void showHeaders(String headers);
  void showError(String error);
}