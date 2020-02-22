package com.uala.gabcast.ualachallenge.errorManager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import retrofit2.adapter.rxjava.HttpException;

public class ErrorHandler {
    public void errorHandlerCode(final Context context, Throwable e, String TAG){
        if(e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case 400:
                    Toast.makeText(context, "onError: BAD REQUEST", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onError: BAD REQUEST");
                    break;
                case 401:
                    Log.d(TAG, "onError: NOT AUTHORIZED");
                    Toast.makeText(context, "onError: NOT AUTHORIZED", Toast.LENGTH_SHORT).show();
                    break;
                case 403:
                    Log.d(TAG, "onError: FORBIDDEN");
                    Toast.makeText(context, "onError: FORBIDDEN", Toast.LENGTH_SHORT).show();
                    break;
                case 404:
                    Toast.makeText(context, "onError: NOT FOUND", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onError: NOT FOUND");
                    break;
                case 500:
                    Toast.makeText(context, "onError: INTERNAL SERVER ERROR", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onError: INTERNAL SERVER ERROR");
                    break;
                case 502:
                    Toast.makeText(context, "onError: BAD GATEWAY", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onError: BAD GATEWAY");
                    break;
                default:
                    Log.d(TAG, "onError: " + httpException.message());
                    break;

            }
        } else {
            Log.d(TAG, "Revise su conexión");
        }
    }
}
