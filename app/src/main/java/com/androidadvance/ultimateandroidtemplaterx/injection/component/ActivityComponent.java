package com.androidadvance.ultimateandroidtemplaterx.injection.component;


import dagger.Component;

import com.androidadvance.ultimateandroidtemplaterx.MainActivity;
import com.androidadvance.ultimateandroidtemplaterx.injection.PerActivity;
import com.androidadvance.ultimateandroidtemplaterx.injection.module.ActivityModule;


/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

}