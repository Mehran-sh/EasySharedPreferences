package com.mehran.easypreferences;

import android.content.SharedPreferences;
import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by Mehran on 12/27/2016.
 */

public abstract class AbstractSharedPreferences {

    public abstract String getKey();

    public String getPrefName()
    {
        return DefaultPrefValues.STRING;
    }
    public int getPrefMode(){ return Context.MODE_PRIVATE; }

    public String getDefaultStringValue() { return DefaultPrefValues.STRING; }
    public int getDefaultIntValue() { return DefaultPrefValues.INT; }
    public boolean getDefaultBooleanValue() { return DefaultPrefValues.BOOLEAN; }

    protected SharedPreferences getSharedPreferences(Context context)
    {
        SharedPreferences sharedPreferences = null;

        String prefName = getPrefName();

        if(prefName.equalsIgnoreCase(DefaultPrefValues.STRING))
        {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        else
        {
            sharedPreferences = context.getSharedPreferences(prefName, getPrefMode());
        }

        return sharedPreferences;
    }
}
