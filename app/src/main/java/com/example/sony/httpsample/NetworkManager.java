package com.example.sony.httpsample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Sony on 12/15/2017.
 */

public class NetworkManager {
    private static NetworkManager instance;
    public static NetworkManager getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new NetworkManager(context);
    }


    private ConnectivityManager connectivityManager;

    private NetworkManager(Context context) {
        this.connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnectedToInternet(){
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
