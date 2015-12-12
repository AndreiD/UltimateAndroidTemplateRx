package com.androidadvance.ultimateandroidtemplaterx.injection.component;

import android.app.Application;


import com.androidadvance.ultimateandroidtemplaterx.data.DataManager;
import com.androidadvance.ultimateandroidtemplaterx.data.SyncService;
import com.androidadvance.ultimateandroidtemplaterx.injection.module.ApplicationModule;
import com.androidadvance.ultimateandroidtemplaterx.ui.activity.MainActivity;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);
    void inject(MainActivity mainActivity);

    Application application();
    DataManager dataManager();
    Bus eventBus();
}