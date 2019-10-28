package com.example.accountbook.present;

import com.example.accountbook.bean.BSort;
import com.example.accountbook.repository.LocalRepository;

import java.util.List;


public class BillNotePresenter extends RxPresenter<BillNoteContract.View> implements BillNoteContract.Presenter {

    private String TAG = "BillNotePresenter";

    @Override
    public void getBillNote() {
        //此处采用同步的方式，防止账单分类出现白块
        mView.loadDataSuccess(LocalRepository.getInstance().getBillNote());
    }

    @Override
    public void updateBBsorts(List<BSort> items) {
        LocalRepository.getInstance().updateBSoers(items);
        mView.onSuccess();
    }

    @Override
    public void addBSort(BSort bSort) {
        LocalRepository.getInstance().saveBSort(bSort);
        mView.onSuccess();
    }

    @Override
    public void deleteBSortByID(Long id) {
        LocalRepository.getInstance().deleteBSortById(id);
        mView.onSuccess();
    }
}
