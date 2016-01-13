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

public interface TheAPIService {

  String ENDPOINT = "http://api.openweathermap.org";


  final String API_KEY  = "2de143494c0b295cca9337e1e96b00e0";

  @GET("/data/2.5/weather?appid=" + API_KEY) Observable<WeatherPojo> getWeatherForLatLon(@Query("lat") double lat, @Query("lng") double lng, @Query("units") String units);

  @GET("/data/2.5/weather?appid="+API_KEY) Observable<WeatherPojo> getWeatherForCity(@Query("q") String city, @Query("units") String units);

  @GET("/data/2.5/forecast?appid="+API_KEY+"&cnt=7") Observable<Forecast> getForecastForCity(@Query("q") String city, @Query("units") String units);

  class Factory {

    private static TheAPIService instance;

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
          new Retrofit.Builder().baseUrl(TheAPIService.ENDPOINT).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
      instance = retrofit.create(TheAPIService.class);
    }

    public static synchronized TheAPIService getApi() {
      if (instance == null) {
        create();
      }
      return instance;
    }
  }
}
