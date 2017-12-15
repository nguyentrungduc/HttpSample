package com.example.sony.httpsample;

import android.app.Application;

/**
 * Created by Sony on 12/15/2017.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(this);
    }
}
