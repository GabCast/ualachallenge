package com.uala.gabcast.ualachallenge.picasso;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.uala.gabcast.ualachallenge.servicios.ClienteRetrofit;

import okhttp3.OkHttpClient;

public class PicassoTrustAll {


    private static Picasso mInstance = null;


    public PicassoTrustAll(Context context) {
        OkHttpClient client = ClienteRetrofit.getSSLConfig(context);


        mInstance = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(client))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                        Log.e("PICASSO", e.getMessage());
                        e.printStackTrace();
                    }
                }).build();

    }

    public static Picasso getInstance(Context context) {
        if (mInstance == null) {
            new PicassoTrustAll(context);
        }
        return mInstance;
    }
}
