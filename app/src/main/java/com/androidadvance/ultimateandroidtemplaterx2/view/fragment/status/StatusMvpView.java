package com.androidadvance.ultimateandroidtemplaterx2.view.fragment.status;

import com.androidadvance.ultimateandroidtemplaterx2.view.MvpView;

public interface StatusMvpView extends MvpView {
  void showHeaders(String headers);
  void showError(String error);
}