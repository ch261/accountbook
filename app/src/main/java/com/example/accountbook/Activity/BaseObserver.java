package com.example.accountbook.Activity;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.example.accountbook.bean.BaseBean;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    protected Context mContext;

    public BaseObserver(Context context) {
        this.mContext = context;
    }

    public BaseObserver() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();

    }

    @Override
    public void onNext(T t) {
        onRequestEnd();
        try {
            onSuccees(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        onRequestEnd();
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                onFailure(e, true);
            } else {
                onFailure(e, false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
    }


    protected abstract void onSuccees(T t) throws Exception;


    protected void onCodeError(T t) throws Exception {
        onFailure(new Throwable(((BaseBean)t).getMessage()),false);
    }

    protected abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;

    protected void onRequestStart() {
    }

    protected void onRequestEnd() {
    }


}  

