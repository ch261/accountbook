package com.example.accountbook.present;

import com.example.accountbook.Activity.BaseContract;
import com.example.accountbook.bean.BBill;
import com.example.accountbook.bean.MonthListBean;



public interface MonthListContract extends BaseContract {

    interface View extends BaseContract.BaseView {

        void loadDataSuccess(MonthListBean list);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getMonthList(String id, String year, String month);

        void deleteBill(Long id);

        void updateBill(BBill bBill);
    }
}
