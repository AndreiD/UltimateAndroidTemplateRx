package com.androidadvance.ultimateandroidtemplaterx.injection.component;

import com.androidadvance.ultimateandroidtemplaterx.data.DataManager;
import com.androidadvance.ultimateandroidtemplaterx.injection.module.DataManagerModule;
import com.androidadvance.ultimateandroidtemplaterx.injection.scope.PerDataManager;

import dagger.Component;

@PerDataManager
@Component(dependencies = ApplicationComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {

    void inject(DataManager dataManager);
}