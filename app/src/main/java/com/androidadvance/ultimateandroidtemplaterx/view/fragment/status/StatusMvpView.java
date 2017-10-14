package com.androidadvance.ultimateandroidtemplaterx.view.fragment.status;

import com.androidadvance.ultimateandroidtemplaterx.view.MvpView;

public interface StatusMvpView extends MvpView {
  void showHeaders(String headers);
  void showError(String error);
}