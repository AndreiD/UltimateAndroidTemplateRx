package com.androidadvance.ultimateandroidtemplaterx.di.component;

import com.androidadvance.ultimateandroidtemplaterx.di.PerActivity;
import com.androidadvance.ultimateandroidtemplaterx.di.module.ActivityModule;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.DetailFragment;
import com.androidadvance.ultimateandroidtemplaterx.view.main.MainActivity;
import com.androidadvance.ultimateandroidtemplaterx.view.settings.SettingsActivity;
import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(MainActivity mainActivity);

  void inject(SettingsActivity settingsActivity);

  void inject(DetailFragment fragment);
}

