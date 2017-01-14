package com.mehran.easypreferences;

import android.content.Context;

/**
 * Created by Mehran on 1/4/2017.
 */

public interface ISharedPreferences<E> {
    void set(Context context, E value);
    E get(Context context);
}
