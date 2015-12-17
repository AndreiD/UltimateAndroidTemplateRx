package com.androidadvance.ultimateandroidtemplaterx.injection.component;

import android.app.Application;


import com.androidadvance.ultimateandroidtemplaterx.data.DataManager;
import com.androidadvance.ultimateandroidtemplaterx.data.SyncService;
import com.androidadvance.ultimateandroidtemplaterx.injection.module.ApplicationModule;
import com.androidadvance.ultimateandroidtemplaterx.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import de.greenrobot.event.EventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);
    void inject(MainActivity mainActivity);

    Application application();
    DataManager dataManager();
    EventBus eventBus();
}