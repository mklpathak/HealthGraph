package com.mukulpathak.healthgraph;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pat on 12/10/2017.
 */

public class MyApplication extends Application {


    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        getKeyHash();
    }

    public MyApplication(Context context) {
        super();
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MyApplication getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyApplication(context);
        }
        return mInstance;
    }

    private static MyApplication mInstance;
    private static Context mCtx;
    RequestQueue requestQueue;
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    void getKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),  // replace with your unique package name
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
            Log.e("Version Code:", ""+info.versionCode);
            Log.e("Version Name:", info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("MyApplicationException", e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            Log.e("MyApplicationException", e.getMessage());
        }
    }
}
