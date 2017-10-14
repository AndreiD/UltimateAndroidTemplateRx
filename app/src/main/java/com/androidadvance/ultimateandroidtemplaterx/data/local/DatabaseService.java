package com.androidadvance.ultimateandroidtemplaterx.data.local;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.androidadvance.ultimateandroidtemplaterx.model.MyObjectBox;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public interface DatabaseService {

  class Factory {

    public static BoxStore create(Context context) {

      BoxStore boxStore = MyObjectBox.builder().androidContext(context).build();

      boolean isDebuggable = (0 != (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));
      if (isDebuggable) {
        new AndroidObjectBrowser(boxStore).start(context);
      }

      return boxStore;
    }
  }
}