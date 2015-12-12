package com.androidadvance.ultimateandroidtemplaterx.injection.module;

import android.content.Context;

import com.androidadvance.ultimateandroidtemplaterx.data.local.DatabaseHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.local.PreferencesHelper;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.APIService;
import com.androidadvance.ultimateandroidtemplaterx.data.remote.RetrofitHelper;
import com.androidadvance.ultimateandroidtemplaterx.injection.scope.PerDataManager;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Provide dependencies to the DataManager, mainly Helper classes and Retrofit services.
 */
@Module
public class DataManagerModule {

    private final Context mContext;

    public DataManagerModule(Context context) {
        mContext = context;
    }

    @Provides
    @PerDataManager
    PreferencesHelper providePreferencesHelper() {
        return new PreferencesHelper(mContext);
    }

    @Provides
    @PerDataManager
    DatabaseHelper provideDatabaseHelper() {
        return new DatabaseHelper(mContext);
    }

    @Provides
    @PerDataManager APIService provideAndroidBoilerplateService() {
        return new RetrofitHelper().newAndroidBoilerplateService();
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}