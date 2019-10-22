package com.example.accountbook;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.accountbook.fragment.MenuFirstFragment;
import com.example.accountbook.fragment.MenuMyFragment;
import com.example.accountbook.fragment.MenuTypeFragment;
import com.example.accountbook.view.BaseBottomBar;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements BaseBottomBar.OnBottomBarListener
         {


    public @BindView(R.id.title_tv)
    TextView titleTv;
    public @BindView(R.id.right_btn)
    ImageView rightBtn;
    public @BindView(R.id.Container)
    FrameLayout Container;
    public @BindView(R.id.main_bottom_bar)
    BaseBottomBar mBottomBar;
    // 当前选中的tab位置
    private int index = 0;
    private FragmentManager mFragmentManager;

    private static final int MSG_CLICK = 20151009;
    private Boolean mCanClickBoolean = true;
    private int MSG_CLICK_DURATION = 200;//能够响应点击事件的时间间隔为0.2s
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (mHandler == null) {
                return;
            }
            int msgNum = msg.what;
            switch (msgNum) {
                case MSG_CLICK:
                    mCanClickBoolean = true;
                    break;
            }
        }
    };




    protected int getLayout() {
        return R.layout.activity_main;
    }

    protected void initEventAndData() {
        mFragmentManager = getSupportFragmentManager();
        mBottomBar.setOnBottomBarListener(this);
        mBottomBar.showTab(0);
    }



    @Override
    public void showFragment(int index) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(index));
        if (fragment == null) {
            if (index == 0) {
                fragment = new MenuFirstFragment();
            } else if (index == 1) {
                fragment = new MenuTypeFragment();

            } else if (index == 2) {
                fragment = new MenuMyFragment();

            }

            if (!fragment.isAdded()) {
                obtainFragmentTransaction(index).add(R.id.Container, fragment, String.valueOf(index)).commitAllowingStateLoss();
            }
        }
        if (fragment != null) {
            obtainFragmentTransaction(index).show(fragment).commitAllowingStateLoss();
        }
        this.index = index;
    }

    @Override
    public void hideFragment(int lastIndex, int curIndex) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(index));
        if (fragment != null) {
            obtainFragmentTransaction(curIndex).hide(fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void refreshView(int index) {
        if (index == 0) {
        } else if (index == 1) {
        } else if (index == 2) {
        }
    }

    @Override
    public void onTabClick(View view) {
        if (!mCanClickBoolean) {
            return;
        }
        mCanClickBoolean = false;
        mHandler.removeMessages(MSG_CLICK);
        mHandler.sendEmptyMessageDelayed(MSG_CLICK,
                MSG_CLICK_DURATION);

        mBottomBar.setCurrentView(view);

        if (index == 0) {
            titleTv.setText("记账");
        } else if (index == 1) {
            titleTv.setText("图表");
        } else if (index == 2) {
            titleTv.setText("账户");
        }

    }


    /**
     * 获取一个带动画的FragmentTransaction
     *
     * @param index
     * @return
     */
    private FragmentTransaction obtainFragmentTransaction(int index) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        // 设置切换动画
        if (index > this.index) {
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
        } else {
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right);
        }
        return ft;
    }


    @OnClick(R.id.right_btn)
    public void onViewClicked() {
    }
}
