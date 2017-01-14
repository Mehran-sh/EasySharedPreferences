package com.mehran.easysharedpreferences.preferences;

import com.mehran.easypreferences.AbstractIntSharedPreferences;

/**
 * Created by Mehran on 12/27/2016.
 */

public class SampleCounterPreference extends AbstractIntSharedPreferences{
    private static final String KEY = "pref_counter_key";

    @Override
    public String getKey() {
        return KEY;
    }
}
