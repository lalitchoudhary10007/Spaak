package com.lalit.spaak_demo.ui.Main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lalit.spaak_demo.R;
import com.lalit.spaak_demo.ui.Base.BaseActivity;
import com.lalit.spaak_demo.ui.Contacts.ContactsFragment;
import com.lalit.spaak_demo.ui.ImageList.ImageListFragment;
import com.lalit.spaak_demo.ui.Map.MapFragment;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    private DrawerLayout drawer;;
    private int currentMenuItem;
    private Fragment fragmentCurrent;
    private TextView mNameTextView;
    private TextView mEmailTextView;
    private ImageListFragment imageListFragment = ImageListFragment.newInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        currentMenuItem = R.id.nav_images;

        getActivityComponent().inject(this);

        mPresenter.onAttach(MainActivity.this);


        setUp();

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerLayout = navigationView.getHeaderView(0);
        mNameTextView = (TextView) headerLayout.findViewById(R.id.tv_name);
        mEmailTextView = (TextView) headerLayout.findViewById(R.id.tv_email);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            addFragment(imageListFragment);
        }

        mPresenter.onNavMenuCreated();
    }






    @Override
    protected void setUp() {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.empty, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(fragmentCurrent.equals(imageListFragment)){
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                super.onBackPressed();
            }else{
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                replaceFragment(imageListFragment);
            }
        }
    }

    @Override
    public void onFragmentAttached() {
        super.onFragmentAttached();
    }

    @Override
    public void onFragmentDetached(String tag) {
        Log.e("Detached:- " , ""+tag);
    }


    private void addFragment(Fragment fragment){
        fragmentCurrent = fragment;
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
    }

    private void replaceFragment(Fragment fragment){
        fragmentCurrent = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragmentSelected = null;
        int id = menuItem.getItemId();
        if(id == currentMenuItem){
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }

        if (id == R.id.nav_images) {
            fragmentSelected = imageListFragment;
        } else if (id == R.id.nav_uploadnew) {
            fragmentSelected = SelectImageFragment.newInstance();
        } else if (id == R.id.nav_contacts) {
            fragmentSelected = ContactsFragment.newInstance();
        } else if (id == R.id.nav_map) {
            fragmentSelected = MapFragment.newInstance();
        }

        currentMenuItem = id;
        replaceFragment(fragmentSelected);

        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void updateUserName(String currentUserName) {
        mNameTextView.setText(currentUserName);
    }

    @Override
    public void updateUserEmail(String currentUserEmail) {
        mEmailTextView.setText(currentUserEmail);
    }
}
