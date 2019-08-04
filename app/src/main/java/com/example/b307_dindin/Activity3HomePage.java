package com.example.b307_dindin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import java.util.ArrayList;

public class Activity3HomePage extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private ArrayList<Fragment> fragments;
    private BottomNavigationBar bottomNavigationBar;
   private AFragment aFragment;
//    private BFragment bFragment;
    private CFragment cFragment;
    private DFragment dFragment;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment fragment;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3homepage);//此处是activity3homepage布局文件，一定要把控件定义在这个布局文件中，否则报错：试图在空对象引用上调用虚方法
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        StatusBarUtil.setImmersiveStatusBar(this,true);//沉浸式状态栏
        init();//初始化控件
        fragments = getFragments();//获得所有fragment
        onTabSelected(0);//设置默认
    }
    private ArrayList<Fragment> getFragments() {
        //实例化Fragment
        aFragment = new AFragment();
        //bFragment = new BFragment();
        cFragment = new CFragment();
        dFragment = new DFragment();
        ArrayList<Fragment> fragments = new ArrayList<>();
       fragments.add(aFragment.newInstance("主页"));
        fragments.add(cFragment.newInstance("拍照评分"));
        fragments.add(dFragment.newInstance("更多"));
        return fragments;
    }
    private void init() {
        bottomNavigationBar  = findViewById(R.id.bottom_Navigation_Bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.homepagegray,"主页").setActiveColorResource(R.color.pigcolor))
                .addItem(new BottomNavigationItem(R.drawable.cameragray, "拍照评分").setActiveColorResource(R.color.pigcolor))
                .addItem(new BottomNavigationItem(R.drawable.minegray, "我的").setActiveColorResource(R.color.pigcolor))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null){
            if (position < fragments.size()){
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                fragment = fragments.get(position);
                String str = Integer.toString(position);
                if (fragment.isAdded()||fragment.isHidden()){
                    ft.show(fragment);
                    Log.d("onTabSelected","点击了"+str);
                }
                else {
                    ft.add(R.id.fl_base,fragment);
                    Log.d("onTabSelected","创建了"+str);
                }
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                fragment = fragments.get(position);
                String str = Integer.toString(position);
                ft.hide(fragment);
                Log.d("onTabReselected","我隐藏了"+str);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {
        if (fragments != null){
            if (position < fragments.size()){
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                fragment = fragments.get(position);
                String str = Integer.toString(position);
                if (fragment.isAdded()||fragment.isHidden()){
                    ft.show(fragment);
                    Log.d("onTabReselected","重复点击了"+str);
                }else {
                    Log.d("onTabReselected","啥都没发生");
                }
                ft.commitAllowingStateLoss();
            }
        }
    }
}




