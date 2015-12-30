package com.androidadvance.ultimateandroidtemplaterx.data.local;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = WeatherDatabase.NAME, version = WeatherDatabase.VERSION)
public class WeatherDatabase {

  public static final String NAME = "weatherdb";
  public static final int VERSION = 1;
}