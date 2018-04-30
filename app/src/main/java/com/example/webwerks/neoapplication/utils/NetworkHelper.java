package com.example.webwerks.neoapplication.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by webwerks on 30/4/18.
 */

public class NetworkHelper {

   public static Context mContext;

   NetworkHelper(Context context ){
       mContext=context;
   }

    public static NetworkHelper create(Context mContext) {
        return new NetworkHelper(mContext);
    }

    public <T> void callWebService(Call<T> call, final NetworkCallback networkCallback) {

         if (Tools.isConnected(mContext)) {
             call.enqueue(new Callback<T>() {
                 @Override
                 public void onResponse(Call<T> call, Response<T> response) {
                     if (response.isSuccessful()) {
                         networkCallback.onSuccess(response.body());
                     } else {
                         Toast.makeText(mContext, "Response Error", Toast.LENGTH_SHORT).show();
                     }
                 }

                 @Override
                 public void onFailure(Call<T> call, Throwable t) {
                     networkCallback.onFailure(t);
                 }
             });
         } else {
             Toast.makeText(mContext, "No internet connected", Toast.LENGTH_SHORT).show();
         }


    }

    public interface NetworkCallback<T> {
        void onSuccess(T data);

        void onFailure(T error);
    }

}
