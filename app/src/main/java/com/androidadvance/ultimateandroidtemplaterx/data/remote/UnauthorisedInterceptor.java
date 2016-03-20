package com.androidadvance.ultimateandroidtemplaterx.data.remote;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.events.AuthenticationErrorEvent;

import java.io.IOException;
import javax.inject.Inject;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.greenrobot.eventbus.EventBus;

public class UnauthorisedInterceptor implements Interceptor {

  @Inject EventBus eventBus;

  public UnauthorisedInterceptor(Context context) {
    BaseApplication.get(context).getApplicationComponent().inject(this);
  }

  @Override public Response intercept(Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());
    if (response.code() == 401) {
      new Handler(Looper.getMainLooper()).post(() -> eventBus.post(new AuthenticationErrorEvent()));
    }
    return response;
  }
}