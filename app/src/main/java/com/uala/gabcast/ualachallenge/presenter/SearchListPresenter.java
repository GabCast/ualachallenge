package com.uala.gabcast.ualachallenge.presenter;

import android.content.Context;
import android.widget.Toast;

import com.uala.gabcast.ualachallenge.listeners.SearchListener;
import com.uala.gabcast.ualachallenge.entitites.Meals;
import com.uala.gabcast.ualachallenge.errorManager.ErrorHandler;
import com.uala.gabcast.ualachallenge.model.ChallengeModel;

import rx.Subscriber;

public class SearchListPresenter {

    private ChallengeModel challengeModel;
    private Context context;
    private SearchListener searchListener;

    public SearchListPresenter(Context context) {
        this.challengeModel = new ChallengeModel(context);
        this.context = context;
        this.searchListener = (SearchListener) context;
    }



    public void searchListBy(String s) {
        final ErrorHandler errorHandler = new ErrorHandler();
        Subscriber<Meals> subscriber = new Subscriber<Meals>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted search");
            }

            @Override
            public void onError(Throwable e) {
                String TAG = "onError search";
                System.out.println(TAG + e.getMessage());
                searchListener.hideProgress();
                errorHandler.errorHandlerCode(context, e, TAG);
            }

            @Override
            public void onNext(Meals r) {
                System.out.println("onNext get getGenericos");
                if (r.getMeals() != null) {
                    if (r.getMeals().size() > 0){
                        searchListener.hideProgress();
                        searchListener.setRecyclerView(r.getMeals());
                    } else
                        Toast.makeText(context, "no hay meals", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(context, "no hay meals", Toast.LENGTH_SHORT).show();
            }
        };
        challengeModel.searchListBy(subscriber, s);
    }



}
