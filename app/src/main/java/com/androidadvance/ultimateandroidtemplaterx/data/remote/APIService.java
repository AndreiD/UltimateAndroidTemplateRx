package com.androidadvance.ultimateandroidtemplaterx.data.remote;

import android.content.Context;
import com.androidadvance.ultimateandroidtemplaterx.BuildConfig;
import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.model.weather.WeatherPojo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIService {

  String ENDPOINT = "http://api.openweathermap.org";
  String API_KEY = "2de143494c0b295cca9337e1e96b00e0";

  @GET("/data/2.5/weather?appid=" + API_KEY) Observable<WeatherPojo> getWeatherForLatLon(@Query("lat") double lat, @Query("lng") double lng, @Query("units") String units);

  @GET("/data/2.5/weather?appid=" + API_KEY) Observable<WeatherPojo> getWeatherForCity(@Query("q") String city, @Query("units") String units);

  @GET("/data/2.5/forecast?appid=" + API_KEY) Observable<Forecast> getForecastForCity(@Query("q") String city, @Query("units") String units, @Query("cnt") int cnt);

  class Factory {

    public static APIService create(Context context) {

      OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
      builder.readTimeout(10, TimeUnit.SECONDS);
      builder.connectTimeout(5, TimeUnit.SECONDS);

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

      builder.addInterceptor(new UnauthorisedInterceptor(context));
      OkHttpClient client = builder.build();

      Retrofit retrofit =
          new Retrofit.Builder().baseUrl(APIService.ENDPOINT).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

      return retrofit.create(APIService.class);
    }
  }
}