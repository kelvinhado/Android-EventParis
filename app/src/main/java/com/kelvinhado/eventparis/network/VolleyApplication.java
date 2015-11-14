package com.kelvinhado.eventparis.network;

import android.app.Application;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * Created by Kelvin HADO
 * on 13/11/15
 * http://www.github.com/kelvinhado
 */

//TODO Add this line to the manifest : android:name=".http.VolleyApplication" in application node
public class VolleyApplication extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
