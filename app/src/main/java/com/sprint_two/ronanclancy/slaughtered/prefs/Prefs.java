package com.sprint_two.ronanclancy.slaughtered.prefs;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import com.sprint_two.ronanclancy.slaughtered.R;


/**
 * Handle preferences
 * <p/>
 * Created by ronanclancy on 1/12/16.
 */
public class Prefs extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefsFragment()).commit();
    }

    public static class PrefsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
           addPreferencesFromResource(R.xml.prefs);
        }
    }
}
