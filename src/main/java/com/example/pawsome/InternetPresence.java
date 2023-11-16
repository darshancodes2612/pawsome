package com.example.pawsome;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

public class InternetPresence {
    public static boolean isInternetAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){
            NetworkRequest networkRequest = new NetworkRequest.Builder().build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    // Network is available
                    // Do something
                }

                @Override
                public void onLost(Network network) {
                    // Network is lost
                    // Do something
                }
            };
            connectivityManager.registerNetworkCallback(networkRequest,networkCallback);

            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        }
        return false;
    }
}
