package com.example.accountbook.present;

import com.example.accountbook.Activity.BaseContract;
import com.example.accountbook.bean.MonthChartBean;




public interface MonthChartContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(MonthChartBean bean);

    }

    interface Presenter extends BasePresenter<View> {

        void getMonthChart(String id, String year, String month);
    }
}
