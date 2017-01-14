package com.mehran.easypreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mehran on 12/27/2016.
 */

public abstract class AbstractIntSharedPreferences
        extends AbstractSharedPreferences
        implements ISharedPreferences<Integer>
{
    @Override
    public void set(Context context, Integer value)
    {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(getKey(), value);
        editor.commit();
    }

    @Override
    public Integer get(Context context)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getInt(getKey(), getDefaultIntValue());
    }
}
