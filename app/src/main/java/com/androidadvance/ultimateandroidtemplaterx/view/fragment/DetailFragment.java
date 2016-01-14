package com.androidadvance.ultimateandroidtemplaterx.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.events.DetailSelectedEvent;
import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.view.BaseFragment;
import com.socks.library.KLog;
import de.greenrobot.event.EventBus;


public class DetailFragment extends BaseFragment implements DetailMvpView {

  private static final String ARG_EXAMPLE = "ARG_EXAMPLE";
  @Bind(R.id.recyclerview_details) RecyclerView recyclerview_details;
  private DetailPresenter presenter;


  public static DetailFragment newInstance(int example_argument) {
    DetailFragment detailFragment = new DetailFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_EXAMPLE, example_argument);
    detailFragment.setArguments(args);
    return detailFragment;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter = new DetailPresenter(getActivity());
    presenter.attachView(this);
    presenter.loadForcast("Sofia,bg");

    recyclerview_details.setHasFixedSize(true);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    recyclerview_details.setLayoutManager(llm);

    //for recreation of the toolbar
    setHasOptionsMenu(true);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int example_argument = getArguments().getInt(ARG_EXAMPLE);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_detail, container, false);
  }

  @Override public void showForecast(Forecast forecast) {

    DetailsAdapter forecast_adapter = new DetailsAdapter(forecast.getList());
    recyclerview_details.setAdapter(forecast_adapter);
  }

  @Override public void onStart() {
    super.onStart();
    EventBus.getDefault().register(this);
  }

  @Override public void onStop() {
    EventBus.getDefault().unregister(this);
    super.onStop();
  }

  public void onEvent(DetailSelectedEvent event) {
    KLog.d(">>> %s", event.details_object);
  }

  @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    menu.clear();
    inflater.inflate(R.menu.menu_fragment_details, menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_detail_refresh:
        presenter.loadForcast("Sofia,bg");
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
