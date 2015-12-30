package com.androidadvance.ultimateandroidtemplaterx.view.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.androidadvance.ultimateandroidtemplaterx.R;

public class SettingsPreferenceFragment extends PreferenceFragment {

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    View view = super.onCreateView(inflater, container, savedInstanceState);
    view.setBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.white));
    addPreferencesFromResource(R.xml.settings);

    Preference buttonfeedback = findPreference(getString(R.string.send_feedback));
    buttonfeedback.setOnPreferenceClickListener(preference -> {
      Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "your_email@gmail.com", null));
      emailIntent.putExtra(Intent.EXTRA_SUBJECT, SettingsPreferenceFragment.this.getString(R.string.app_name) + " Feedback");
      emailIntent.putExtra(Intent.EXTRA_TEXT, "Write your feedback here...");
      startActivity(Intent.createChooser(emailIntent, "Send email..."));

      return true;
    });

    return view;
  }
}