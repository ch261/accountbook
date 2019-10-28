package com.example.accountbook.present;

import com.example.accountbook.Activity.BaseObserver;
import com.example.accountbook.bean.BBill;
import com.example.accountbook.repository.LocalRepository;
import com.example.accountbook.utils.BillUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;




public class MonthChartPresenter extends RxPresenter<MonthChartContract.View> implements MonthChartContract.Presenter{

    private String TAG="MonthChartPresenter";

    @Override
    public void getMonthChart(String id, String year, String month) {
        LocalRepository.getInstance().getBBillByUserIdWithYM(id, year, month)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<BBill>>() {
                    @Override
                    protected void onSuccees(List<BBill> bBills) throws Exception {
                        mView.loadDataSuccess(BillUtils.packageChartList(bBills));
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mView.onFailure(e);
                    }
                });
    }
}
