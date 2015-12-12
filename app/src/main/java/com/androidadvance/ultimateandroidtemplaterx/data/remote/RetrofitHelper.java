package com.androidadvance.ultimateandroidtemplaterx.data.remote;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RetrofitHelper {

    public APIService newAndroidBoilerplateService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(APIService.class);
    }

}
