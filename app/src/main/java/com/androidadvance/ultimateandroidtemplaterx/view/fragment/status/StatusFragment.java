package com.androidadvance.ultimateandroidtemplaterx.view.fragment.status;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.events.MessagesEvent;
import com.androidadvance.ultimateandroidtemplaterx.util.DialogFactory;
import com.androidadvance.ultimateandroidtemplaterx.view.BaseFragment;
import com.socks.library.KLog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class StatusFragment extends BaseFragment implements StatusMvpView {

  //@BindView(R.id.textView_fragment_headers) TextView textView_fragment_headers;

  public static StatusFragment newInstance() {
    StatusFragment statusFragment = new StatusFragment();

    return statusFragment;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    StatusPresenter presenter = new StatusPresenter(getActivity());
    presenter.attachView(this);

    //load the headers on creation
    presenter.show_headers();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_status, container, false);
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

  @Override public void showError(String error) {
    try {
      DialogFactory.createGenericErrorDialog(getActivity(), error).show();
    }catch (Exception ex){
      KLog.e(ex);
    }
  }
}
