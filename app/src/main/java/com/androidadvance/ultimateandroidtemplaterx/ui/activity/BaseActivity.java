package com.androidadvance.ultimateandroidtemplaterx.ui.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.androidadvance.ultimateandroidtemplaterx.AndroidBoilerplateApplication;
import com.androidadvance.ultimateandroidtemplaterx.injection.component.ApplicationComponent;


public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected ApplicationComponent applicationComponent() {
        return AndroidBoilerplateApplication.get(this).getComponent();
    }

}
