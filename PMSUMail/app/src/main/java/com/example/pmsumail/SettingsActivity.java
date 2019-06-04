package com.example.pmsumail;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        // Ako je otkacen ascending, ne moze da bude otkacen descending i obrnuto
        CheckBoxPreference cbAsc = (CheckBoxPreference) findPreference(getString(R.string.pref_sort_messages_by_date_key_list_asc));
        CheckBoxPreference cbDesc = (CheckBoxPreference) findPreference(getString(R.string.pref_sort_messages_by_date_key_list_desc));
        if (cbAsc.isChecked() && cbAsc.isEnabled()){
            cbDesc.setEnabled(false);
        }
        else if (cbDesc.isChecked() && cbDesc.isEnabled()){
            cbAsc.setEnabled(false);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
