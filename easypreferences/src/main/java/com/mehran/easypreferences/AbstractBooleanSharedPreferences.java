package com.mehran.easypreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mehran on 12/27/2016.
 */

public abstract class AbstractBooleanSharedPreferences
        extends AbstractSharedPreferences
        implements ISharedPreferences<Boolean>
{
    @Override
    public void set(Context context, Boolean value)
    {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(getKey(), value);
        editor.commit();
    }

    @Override
    public Boolean get(Context context)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getBoolean(getKey(), getDefaultBooleanValue());
    }
}
