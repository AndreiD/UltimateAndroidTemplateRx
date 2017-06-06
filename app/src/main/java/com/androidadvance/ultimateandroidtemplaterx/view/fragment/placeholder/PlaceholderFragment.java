package com.androidadvance.ultimateandroidtemplaterx.view.fragment.placeholder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Optional;
import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.events.MessagesEvent;
import com.androidadvance.ultimateandroidtemplaterx.util.DialogFactory;
import com.androidadvance.ultimateandroidtemplaterx.view.BaseFragment;
import com.socks.library.KLog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PlaceholderFragment extends BaseFragment implements PlaceholderMvpView {

    private static final String ARG_EXAMPLE = "ARG_EXAMPLE";
  // @BindView(R.id.textView_fragment_headers) TextView textView_fragment_headers;

  public static PlaceholderFragment newInstance() {
    PlaceholderFragment placeholderFragment = new PlaceholderFragment();
    return placeholderFragment;
  }

  public static PlaceholderFragment newInstance(int example_argument) {
    PlaceholderFragment placeholderFragment = new PlaceholderFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_EXAMPLE, example_argument);
    placeholderFragment.setArguments(args);
    return placeholderFragment;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    PlaceholderPresenter presenter = new PlaceholderPresenter(getActivity());
    presenter.attachView(this);

    //load the headers on creation
    presenter.show_headers();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //int example_argument = getArguments().getInt(ARG_EXAMPLE);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_placeholder, container, false);
  }

  @Override
  public void onStart() {
    super.onStart();
    EventBus.getDefault().register(this);
  }

  @Override
  public void onStop() {
    EventBus.getDefault().unregister(this);
    super.onStop();
  }

  @Subscribe
  public void onEvent(MessagesEvent event) {
    KLog.d(">>> %s", event.toString());
  }

  @Override
  public void showHeaders(String headers) {
    //textView_fragment_headers.setText(headers);
  }

  @Override
  public void showError(String error) {
    DialogFactory.createGenericErrorDialog(getActivity(), error).show();
  }
}
