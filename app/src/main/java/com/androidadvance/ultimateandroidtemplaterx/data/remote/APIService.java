package com.androidadvance.ultimateandroidtemplaterx.data.remote;

import com.androidadvance.ultimateandroidtemplaterx.model.forecast.Forecast;
import com.androidadvance.ultimateandroidtemplaterx.model.weather.WeatherPojo;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import java.util.concurrent.TimeUnit;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public interface ApiService {

  String ENDPOINT = "http://api.openweathermap.org";

  @GET("/data/2.5/weather?appid=2de143494c0b295cca9337e1e96b00e0") Observable<WeatherPojo> getWeatherForLatLon(@Query("lat") double lat, @Query("lng") double lng, @Query("units") String units);

  @GET("/data/2.5/weather?appid=2de143494c0b295cca9337e1e96b00e0") Observable<WeatherPojo> getWeatherForCity(@Query("q") String city, @Query("units") String units);

  @GET("/data/2.5/forecast?appid=2de143494c0b295cca9337e1e96b00e0&cnt=3") Observable<Forecast> getForecastForCity(@Query("q") String city, @Query("units") String units);

  class Factory {

    private static ApiService instance;

    private static void create() {

      OkHttpClient client = new OkHttpClient();
      client.setConnectTimeout(5, TimeUnit.SECONDS);
      client.setReadTimeout(10, TimeUnit.SECONDS);

      //------- enable logging ------
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      client.interceptors().add(interceptor);

      //Extra Headers
      //client.networkInterceptors().add(chain -> {
      //  Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
      //  return chain.proceed(request);
      //});

      final Retrofit retrofit =
          new Retrofit.Builder().baseUrl(ApiService.ENDPOINT).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
      instance = retrofit.create(ApiService.class);
    }

    public static synchronized ApiService getApi() {
      if (instance == null) {
        create();
      }
      return instance;
    }
  }
}
