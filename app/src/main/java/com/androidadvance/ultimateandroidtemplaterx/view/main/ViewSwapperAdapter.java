package com.androidadvance.ultimateandroidtemplaterx.view.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.androidadvance.ultimateandroidtemplaterx.util.adaptablebottomnavigation.adapter.FragmentStateAdapter;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.build.BuildFragment;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.menu.MenuFragment;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.placeholder.PlaceholderFragment;
import com.androidadvance.ultimateandroidtemplaterx.view.fragment.status.StatusFragment;

public class ViewSwapperAdapter extends FragmentStateAdapter {

  public ViewSwapperAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return BuildFragment.newInstance();
      case 1:
        return MenuFragment.newInstance();
      case 2:
        return StatusFragment.newInstance();
    }
    return PlaceholderFragment.newInstance();
  }

  @Override
  public int getCount() {
    return 3;
  }
}