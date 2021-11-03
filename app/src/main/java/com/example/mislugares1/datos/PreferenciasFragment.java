package com.example.mislugares1.datos;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.mislugares1.R;

public class PreferenciasFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferencias, rootKey);
    }
}
