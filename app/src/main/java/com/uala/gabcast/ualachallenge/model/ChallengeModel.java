package com.uala.gabcast.ualachallenge.model;

import android.content.Context;

import com.uala.gabcast.ualachallenge.entitites.Meals;
import com.uala.gabcast.ualachallenge.servicios.api.ClientAPI;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ChallengeModel {

    private Context context;
    public ChallengeModel(Context context) {
        this.context = context;
    }

    public void searchListBy(final Subscriber<Meals> subscriber, String s) {

        Observable<Meals> result = ClientAPI.getClient(context).searchList(s);

        result.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    public void searchRandom(final Subscriber<Meals> subscriber) {

        Observable<Meals> result = ClientAPI.getClient(context).searchRandom();

        result.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

}