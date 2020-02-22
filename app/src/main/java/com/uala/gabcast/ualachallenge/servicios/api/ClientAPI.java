package com.uala.gabcast.ualachallenge.servicios.api;

import android.content.Context;

import com.uala.gabcast.ualachallenge.R;
import com.uala.gabcast.ualachallenge.servicios.ClienteRetrofit;
import com.uala.gabcast.ualachallenge.servicios.ualaApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientAPI {

    private static ualaApi instance;

    public static ualaApi getClient(Context context) {
        if(instance == null) {
            OkHttpClient localClient = ClienteRetrofit.getSSLConfig(context);

            assert localClient != null;
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(context.getResources().getString(R.string.BASE_URL_SERVER_DESA))
                    .client(localClient)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());
            instance = builder.build()
                    .create(ualaApi.class);
        }
        return instance;
    }
}
