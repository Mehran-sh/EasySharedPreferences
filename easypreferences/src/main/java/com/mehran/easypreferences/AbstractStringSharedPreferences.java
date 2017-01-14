package com.mehran.easypreferences;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * Created by Mehran on 12/27/2016.
 */

public abstract class AbstractStringSharedPreferences
        extends AbstractSharedPreferences
        implements ISharedPreferences<String>
{
    @Override
    public void set(Context context, String value)
    {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(getKey(), value);
        editor.commit();
    }

    @Override
    public String get(Context context)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getString(getKey(), getDefaultStringValue());
    }
}
