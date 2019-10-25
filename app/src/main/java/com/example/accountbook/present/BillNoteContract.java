package com.example.accountbook.present;

import com.example.accountbook.Activity.BaseContract;
import com.example.accountbook.bean.BSort;
import com.example.accountbook.bean.NoteBean;

import java.util.List;



public interface BillNoteContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(NoteBean bean);

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 获取信息
         */
        void getBillNote();

        void updateBBsorts(List<BSort> items);

        void addBSort(BSort bSort);
        void deleteBSortByID(Long id);
    }
}
