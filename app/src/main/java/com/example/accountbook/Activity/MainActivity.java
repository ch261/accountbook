package com.example.accountbook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.example.accountbook.R;
import com.example.accountbook.adapter.MainFragmentPagerAdapter;
import com.example.accountbook.bean.BSort;
import com.example.accountbook.bean.MyUser;
import com.example.accountbook.bean.NoteBean;
import com.example.accountbook.common.Constants;
import com.example.accountbook.fragment.MonthChartFragment;
import com.example.accountbook.fragment.MonthListFragment;
import com.example.accountbook.repository.LocalRepository;
import com.example.accountbook.utils.DateUtils;
import com.example.accountbook.utils.GlideCacheUtil;
import com.example.accountbook.utils.SharedPUtils;
import com.example.accountbook.utils.SnackbarUtils;
import com.example.accountbook.utils.ThemeManager;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobUser;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private TextView tOutcome;
    private TextView tIncome;
    private TextView tTotal;

    private View drawerHeader;
    private ImageView drawerIv;
    private TextView drawerTvAccount, drawerTvMail;

    protected static final int USERINFOACTIVITY_CODE = 0;
    protected static final int LOGINACTIVITY_CODE = 1;

    // Tab
    private FragmentManager mFragmentManager;
    private MainFragmentPagerAdapter mFragmentPagerAdapter;
    private MonthListFragment monthListFragment;
    private MonthChartFragment monthChartFragment;


    private MyUser currentUser;

    /***************************************************************************/
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);


        if (SharedPUtils.isFirstStart(mContext)) {
            NoteBean note = new Gson().fromJson(Constants.BILL_NOTE, NoteBean.class);
            List<BSort> sorts = note.getOutSortlis();
            sorts.addAll(note.getInSortlis());
            LocalRepository.getInstance().saveBsorts(sorts);
            LocalRepository.getInstance().saveBPays(note.getPayinfo());
        }

        monthListFragment = new MonthListFragment();
        monthChartFragment = new MonthChartFragment();
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.main_viewpager);
        drawer = findViewById(R.id.main_drawer);
        navigationView = findViewById(R.id.main_nav_view);
        tOutcome = findViewById(R.id.t_outcome);
        tIncome = findViewById(R.id.t_income);
        tTotal = findViewById(R.id.t_total);

        //初始化Toolbar
        toolbar.setTitle("accountbook");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawerHeader = navigationView.inflateHeaderView(R.layout.drawer_header);
        drawerIv = drawerHeader.findViewById(R.id.drawer_iv);
        drawerTvAccount = drawerHeader.findViewById(R.id.drawer_tv_name);
        drawerTvMail = drawerHeader.findViewById(R.id.drawer_tv_mail);


        setDrawerHeaderAccount();

        //初始化ViewPager
        mFragmentManager = getSupportFragmentManager();
        mFragmentPagerAdapter = new MainFragmentPagerAdapter(mFragmentManager);
        mFragmentPagerAdapter.addFragment(monthListFragment, "明细");
        mFragmentPagerAdapter.addFragment(monthChartFragment, "图表");

        monthListFragment.setMonthListListener((outcome, income, total) -> {
            tOutcome.setText(outcome);
            tIncome.setText(income);
            tTotal.setText(total);
        });

        viewPager.setAdapter(mFragmentPagerAdapter);

        //初始化TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("明细"));
        tabLayout.addTab(tabLayout.newTab().setText("图表"));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initClick() {
        super.initClick();

        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_date:

                new TimePickerBuilder(mContext, (Date date, View v) -> {
                    monthListFragment.changeDate(DateUtils.date2Str(date, "yyyy"), DateUtils.date2Str(date, "MM"));
                    monthChartFragment.changeDate(DateUtils.date2Str(date, "yyyy"), DateUtils.date2Str(date, "MM"));
                }).setType(new boolean[]{true, true, false, false, false, false})
                        .setRangDate(null, Calendar.getInstance())
                        .isDialog(true)
                        .build().show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_setting:
                SnackbarUtils.show(mContext, "还未开放此功能");
                break;
            case R.id.nav_theme:
                showUpdateThemeDialog();
                break;
            case R.id.nav_exit:
                exitUser();
                break;
            default:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    private void showUpdateThemeDialog() {
        String[] themes = ThemeManager.getInstance().getThemes();
        new MaterialDialog.Builder(mContext)
                .title("选择主题")
                .titleGravity(GravityEnum.CENTER)
                .items(themes)
                .negativeText("取消")
                .itemsCallback(((dialog, itemView, position, text) -> {
                    ThemeManager.getInstance().setTheme(mActivity, themes[position]);
                }))
                .show();
    }


    private void exitUser(){
        new MaterialDialog.Builder(mContext)
                .title("确认退出")
                .content("退出后将清空所有数据")
                .positiveText("确定")
                .onPositive((dialog, which) -> {
                    GlideCacheUtil.getInstance().clearImageDiskCache(mContext);
                    MyUser.logOut();
                    //清除本地数据
                    LocalRepository.getInstance().deleteAllBills();
                    //重启
                    finish();
                    Intent intent = getIntent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                })
                .negativeText("取消")
                .show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case USERINFOACTIVITY_CODE:
                    setDrawerHeaderAccount();
                    break;
                case LOGINACTIVITY_CODE:
                    setDrawerHeaderAccount();
                    break;
            }
        }
    }

    public void setDrawerHeaderAccount() {
        currentUser = BmobUser.getCurrentUser(MyUser.class);

            drawerTvAccount.setText("账号");
            drawerIv.setImageResource(R.mipmap.ic_def_icon);

    }
}
