package com.mehran.easypreferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

/**
 * Created by Mehran on 12/27/2016.
 */

public abstract class AbstractObjectSharedPreferences<E>
        extends AbstractSharedPreferences
        implements ISharedPreferences<E>
{
    final Class<E> typeParamererClass;

    public AbstractObjectSharedPreferences(Class<E> typeParamererClass)
    {
        this.typeParamererClass = typeParamererClass;
    }

    @Override
    public void set(Context context, E value)
    {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        String strObj = convertObjectToJson(value);
        editor.putString(getKey(), strObj);
    }

    @Override
    public E get(Context context)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        String strObj = preferences.getString(getKey(), DefaultPrefValues.STRING);

        if(strObj.equalsIgnoreCase(DefaultPrefValues.STRING))
        {
            return null;
        }
        else
        {
            return convertJsonToObject(strObj, typeParamererClass);
        }
    }

    private <E> String convertObjectToJson(E obj)
    {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;
    }

    private <E> E convertJsonToObject(String strObj, Class<E> c)
    {
        Gson gson = new Gson();
        E obj = gson.fromJson(strObj, c);
        return obj;
    }
}
