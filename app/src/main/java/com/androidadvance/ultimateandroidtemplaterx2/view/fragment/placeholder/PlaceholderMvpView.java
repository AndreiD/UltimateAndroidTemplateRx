package com.androidadvance.ultimateandroidtemplaterx2.view.fragment.placeholder;

import com.androidadvance.ultimateandroidtemplaterx2.view.MvpView;

public interface PlaceholderMvpView extends MvpView {
  void showHeaders(String headers);
  void showError(String error);
}