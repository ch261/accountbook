package com.example.accountbook.repository;

import com.example.accountbook.bean.BBill;
import com.example.accountbook.bean.BPay;
import com.example.accountbook.bean.BSort;
import com.example.accountbook.bean.NoteBean;
import com.example.accountbook.gen.BBillDao;
import com.example.accountbook.gen.BSortDao;
import com.example.accountbook.gen.DaoSession;
import com.example.accountbook.utils.DateUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class LocalRepository {

    private static final String TAG = "LocalRepository";
    private static final String DISTILLATE_ALL = "normal";
    private static final String DISTILLATE_BOUTIQUES = "distillate";

    private static volatile LocalRepository sInstance;
    private DaoSession mSession;

    private LocalRepository() {
        mSession = DaoDbHelper.getInstance().getSession();
    }

    public static LocalRepository getInstance() {
        if (sInstance == null) {
            synchronized (LocalRepository.class) {
                if (sInstance == null) {
                    sInstance = new LocalRepository();
                }
            }
        }
        return sInstance;
    }

    /******************************save**************************************/
    public Observable<BBill> saveBBill(final BBill bill) {
        return Observable.create(new ObservableOnSubscribe<BBill>() {
            @Override
            public void subscribe(ObservableEmitter<BBill> e) throws Exception {
                mSession.getBBillDao().insert(bill);
                e.onNext(bill);
                e.onComplete();
            }
        });
    }

    /**
     * 批量添加账单
     *
     * @param bBills
     */
    public void saveBBills(List<BBill> bBills) {
        mSession.getBBillDao().insertInTx(bBills);
    }

    public Long saveBPay(BPay pay) {
        return mSession.getBPayDao().insert(pay);
    }

    public Long saveBSort(BSort sort) {
        return mSession.getBSortDao().insert(sort);
    }

    /**
     * 批量添加支付方式
     *
     * @param pays
     */
    public void saveBPays(List<BPay> pays) {
        for (BPay pay : pays)
            saveBPay(pay);
    }

    /**
     * 批量添加账单分类
     *
     * @param sorts
     */
    public void saveBsorts(List<BSort> sorts) {
        for (BSort sort : sorts)
            saveBSort(sort);
    }

    /******************************get**************************************/
    public BBill getBBillById(int id) {
        return mSession.getBBillDao().queryBuilder()
                .where(BBillDao.Properties.Id.eq(id)).unique();
    }

    public List<BBill> getBBills() {
        return mSession.getBBillDao().queryBuilder().list();
    }

    public Observable<List<BBill>> getBBillByUserId(int id) {
        QueryBuilder<BBill> queryBuilder = mSession.getBBillDao()
                .queryBuilder()
                .where(BBillDao.Properties.Userid.eq(id));
        return queryListToRx(queryBuilder);
    }

    public Observable<List<BBill>> getBBillByUserIdWithYM(String id, String year, String month) {
        String startStr = year + "-" + month + "-00 00:00:00";
        Date date = DateUtils.str2Date(startStr);
        Date endDate = DateUtils.addMonth(date, 1);
        QueryBuilder<BBill> queryBuilder = mSession.getBBillDao()
                .queryBuilder()
                .where(BBillDao.Properties.Crdate.between(DateUtils.getMillis(date), DateUtils.getMillis(endDate)))
                .where(BBillDao.Properties.Version.ge(0))
                .orderDesc(BBillDao.Properties.Crdate);
        return queryListToRx(queryBuilder);
    }

    public Observable<List<BSort>> getBSort(boolean income) {
        QueryBuilder<BSort> queryBuilder = mSession.getBSortDao()
                .queryBuilder()
                .where(BSortDao.Properties.Income.eq(income));
        return queryListToRx(queryBuilder);
    }

    public Observable<List<BSort>> getBSort() {
        QueryBuilder<BSort> queryBuilder = mSession.getBSortDao()
                .queryBuilder();
        return queryListToRx(queryBuilder);
    }

    public Observable<List<BPay>> getBPay() {
        QueryBuilder<BPay> queryBuilder = mSession.getBPayDao()
                .queryBuilder();
        return queryListToRx(queryBuilder);
    }

    public NoteBean getBillNote() {
        NoteBean note = new NoteBean();
        note.setPayinfo(mSession.getBPayDao().queryBuilder().list());
        note.setInSortlis(mSession.getBSortDao().queryBuilder()
                .where(BSortDao.Properties.Income.eq(true)).orderAsc(BSortDao.Properties.Priority).list());
        note.setOutSortlis(mSession.getBSortDao().queryBuilder()
                .where(BSortDao.Properties.Income.eq(false)).orderAsc(BSortDao.Properties.Priority).list());
        return note;
    }




    public void updateBBillByBmob(BBill bill) {
        mSession.getBBillDao().update(bill);
    }


    public Observable<BBill> updateBBill(final BBill bill) {

        return Observable.create(new ObservableOnSubscribe<BBill>() {
            @Override
            public void subscribe(ObservableEmitter<BBill> e) throws Exception {
                mSession.getBBillDao().update(bill);
                e.onNext(bill);
                e.onComplete();
            }
        });
    }


    public void updateBSoers(List<BSort> items){
        mSession.getBSortDao().updateInTx(items);
    }


    public void deleteBSortById(Long id) {
        mSession.getBSortDao().deleteByKey(id);
    }


    public void deleteBPayById(Long id) {
        mSession.getBPayDao().deleteByKey(id);
    }


    public void deleteBills(List<BBill> bBills) {
        mSession.getBBillDao().deleteInTx(bBills);
    }


    public void deleteAllBills() {
        deleteBills(getBBills());
    }

    public Observable<Long> deleteBBillById(Long id) {
        mSession.getBBillDao().deleteByKey(id);
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> e) throws Exception {
                e.onNext(new Long(0));
                e.onComplete();
            }
        });
    }

    private <T> Observable<T> queryToRx(final QueryBuilder<T> builder) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                T data = builder.list().get(0);
                e.onNext(data);
                e.onComplete();
            }
        });
    }

    private <T> Observable<List<T>> queryListToRx(final QueryBuilder<T> builder) {
        return Observable.create(new ObservableOnSubscribe<List<T>>() {
            @Override
            public void subscribe(ObservableEmitter<List<T>> e) throws Exception {
                List<T> data = builder.list();
                e.onNext(data);
                e.onComplete();
            }
        });
    }

}
