package com.androidadvance.ultimateandroidtemplaterx2.di.component;

import com.androidadvance.ultimateandroidtemplaterx2.di.PerActivity;
import com.androidadvance.ultimateandroidtemplaterx2.di.module.ActivityModule;
import com.androidadvance.ultimateandroidtemplaterx2.view.fragment.placeholder.PlaceholderFragment;
import com.androidadvance.ultimateandroidtemplaterx2.view.fragment.status.StatusFragment;
import com.androidadvance.ultimateandroidtemplaterx2.view.main.MainActivity;
import com.androidadvance.ultimateandroidtemplaterx2.view.settings.SettingsActivity;
import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(MainActivity mainActivity);

  void inject(SettingsActivity settingsActivity);

  void inject(StatusFragment fragment);

  void inject(PlaceholderFragment fragment);
}

