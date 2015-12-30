package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.view.BaseFragment;


public class DetailFragment extends BaseFragment implements DetailMvpView {

  private static final String ARG_DAYS_IN_ADVANCE = "ARG_DAYS_IN_ADVANCE";
  private int days_in_advance;
  @Bind(R.id.textView_fragment_info) TextView textView_fragment_info;

  public static DetailFragment newInstance(int days_in_advance) {
    DetailFragment detailFragment = new DetailFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_DAYS_IN_ADVANCE, days_in_advance);
    detailFragment.setArguments(args);
    return detailFragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    DetailPresenter presenter = new DetailPresenter();
    presenter.attachView(this);
    presenter.loadForcast("Sofia,bg");
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    days_in_advance = getArguments().getInt(ARG_DAYS_IN_ADVANCE);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_detail, container, false);
  }

  @Override public void showForecast(Forecast forecast) {
    textView_fragment_info.setText(forecast.getList().get(days_in_advance).toString());
  }
}
