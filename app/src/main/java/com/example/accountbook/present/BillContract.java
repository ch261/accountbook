package com.example.accountbook.present;

import com.example.accountbook.Activity.BaseContract;
import com.example.accountbook.bean.BBill;
import com.example.accountbook.bean.NoteBean;




public interface BillContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(NoteBean bean);

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 获取信息
         */
        void getBillNote();

        /**
         * 添加账单
         */
        void addBill(BBill bBill);

        /**
         * 修改账单
         */
        void updateBill(BBill bBill);


        /**
         * 删除账单
         */
        void deleteBillById(Long id);
    }
}
