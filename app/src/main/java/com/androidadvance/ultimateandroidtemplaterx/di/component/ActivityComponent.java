package com.androidadvance.ultimateandroidtemplaterx.di.component;

import com.androidadvance.ultimateandroidtemplaterx.di.ActivityScope;
import com.androidadvance.ultimateandroidtemplaterx.view.main.MainActivity;
import com.androidadvance.ultimateandroidtemplaterx.view.settings.SettingsActivity;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends ApplicationComponent {

  void inject(MainActivity mainActivity);

  void inject(SettingsActivity settingsActivity);
}