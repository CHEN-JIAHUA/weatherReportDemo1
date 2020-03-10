package com.chenjiahua.myapplicationdemo1.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.chenjiahua.myapplicationdemo1.R;
import com.chenjiahua.myapplicationdemo1.base.BaseFragment;
import com.chenjiahua.myapplicationdemo1.ui.fragment.HomeFragment;
import com.chenjiahua.myapplicationdemo1.ui.fragment.SelecAreaFragment;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private Unbinder bind;

    @BindView(R.id.nav_view)
    public NavigationView navView;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.drawer_view)
    DrawerLayout drawerView;

    private HomeFragment mHomeFragment;
    private SelecAreaFragment mSelectAreaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerView, toolbar,0, 0);
        drawerView.addDrawerListener(toggle);
        toggle.syncState();


//        加载视图
        initView();
        initListener();

    }

    private void initListener() {
        navView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if(itemId == R.id.home_page){
                switchFragment(mHomeFragment);
            }else if (itemId == R.id.select_area_page){
                switchFragment(mSelectAreaFragment);
            }
            return true;
        });
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_view,targetFragment);
        transaction.commit();
    }

    private void initView() {
        mHomeFragment = new HomeFragment();
        mSelectAreaFragment = new SelecAreaFragment();
        switchFragment(mHomeFragment);          //
    }
}
