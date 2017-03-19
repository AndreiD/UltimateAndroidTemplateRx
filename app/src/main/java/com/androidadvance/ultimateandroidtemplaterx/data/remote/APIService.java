package com.androidadvance.ultimateandroidtemplaterx.data.remote;

import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.BuildConfig;
import com.androidadvance.ultimateandroidtemplaterx.model.IPInfo;
import com.androidadvance.ultimateandroidtemplaterx.util.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socks.library.KLog;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIService {

  String ENDPOINT = "http://ip-api.com/";

  @GET("json") Call<IPInfo> getHeaders();

  class Factory {

    public static APIService create(Context context, boolean cached) {

      OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
      builder.readTimeout(15, TimeUnit.SECONDS);
      builder.connectTimeout(10, TimeUnit.SECONDS);
      builder.writeTimeout(10, TimeUnit.SECONDS);

      //builder.certificatePinner(new CertificatePinner.Builder().add("*.androidadvance.com", "sha256/RqzElicVPA6LkKm9HblOvNOUqWmD+4zNXcRb+WjcaAE=")
      //    .add("*.xxxxxx.com", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=")
      //    .add("*.xxxxxxx.com", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=")
      //    .add("*.xxxxxxx.com", "sha256/VjLZe/p3W/PJnd6lL8JVNBCGQBZynFLdZSTIqcO0SJ8=")
      //    .build());

      if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        builder.addInterceptor(interceptor);
      }

      //Extra Headers
      //builder.addNetworkInterceptor().add(chain -> {
      //  Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
      //  return chain.proceed(request);
      //});

      if (cached) {
        Cache cache = new Cache(context.getCacheDir(), 10 * 1024 * 1024);
        builder.cache(cache);
        builder.addInterceptor(chain -> {
          Request request = chain.request();
          if (NetworkUtil.isNetworkConnected(context)) {
            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
          } else {
            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
          }
          return chain.proceed(request);
        });
      }

      //builder.addInterceptor(new UnauthorisedInterceptor(context));

      OkHttpClient client = builder.build();

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

      Retrofit retrofit =
          new Retrofit.Builder().baseUrl(APIService.ENDPOINT).client(client).addConverterFactory(GsonConverterFactory.create(gson)).build();

      return retrofit.create(APIService.class);
    }
  }
}