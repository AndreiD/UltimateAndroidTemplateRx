package com.androidadvance.ultimateandroidtemplaterx.view.fragment.placeholder;

import com.androidadvance.ultimateandroidtemplaterx.view.MvpView;

public interface PlaceholderMvpView extends MvpView {
  void showHeaders(String headers);
  void showError(String error);
}