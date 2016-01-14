package com.androidadvance.ultimateandroidtemplaterx.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {

  private static SharedPreferences mPref;

  public static final String PREF_FILE_NAME = "myapp_shared_prefs";
  private static final String KEY_USER_ID = "user_id";
  private static final String KEY_NOTIFICATIONS_PREFERENCES = "notifications_preferences";

  public PreferencesHelper(Context context) {
    mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
  }

  public void clear() {
    mPref.edit().clear().apply();
  }

  public long getUserId() {
    return mPref.getLong(KEY_USER_ID, 1);
  }

  public void setUserId(long userId) {
    mPref.edit().putLong(KEY_USER_ID, userId).apply();
  }

  public boolean getNotificationsPrefs() {
    return mPref.getBoolean(KEY_NOTIFICATIONS_PREFERENCES, false);
  }

  public void setNotificationsPrefs(boolean acceptsNotifications) {
    mPref.edit().putBoolean(KEY_NOTIFICATIONS_PREFERENCES, acceptsNotifications).apply();
  }
}
