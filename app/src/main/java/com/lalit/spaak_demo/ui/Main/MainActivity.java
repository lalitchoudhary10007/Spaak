package com.lalit.spaak_demo.ui.Main;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.lalit.spaak_demo.R;
import com.lalit.spaak_demo.ui.Base.BaseActivity;
import com.lalit.spaak_demo.ui.Contacts.ContactsFragment;
import com.lalit.spaak_demo.ui.ImageList.ImageListFragment;
import com.lalit.spaak_demo.ui.Map.MapFragment;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageFragment;
import com.lalit.spaak_demo.ui.Splash.SplashActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    DrawerLayout drawerLayout ;

    FragmentManager fragmentManager ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mPresenter.onAttach(MainActivity.this);

        configureToolbar();
        fragmentManager = getSupportFragmentManager();

        setUp();

    }






    @Override
    protected void setUp() {

        fragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.fragment_container, ImageListFragment.newInstance(), ImageListFragment.TAG)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.empty, menu);
        return true;
    }

    private void configureToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black);
        actionbar.setDisplayHomeAsUpEnabled(true);

        configureNavigationDrawer();
    }

    private void configureNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (menuItem.getItemId()) {
                    case R.id.nav_images:
                        mPresenter.onDrawerOptionImageListClick();
                        return true;
                    case R.id.nav_uploadnew:
                        mPresenter.onDrawerOptionSelectImageClick();
                        return true;
                    case R.id.nav_contacts:
                        mPresenter.onDrawerMyContactsClick();
                        return true;
                    case R.id.nav_map:
                        mPresenter.onDrawerMapClick();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch(itemId) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            // manage other entries if you have it ...
        }
        return true;
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        int count = fragmentManager.getBackStackEntryCount();
        Log.e("count" , ""+count);
        if (count == 0) {
            super.onBackPressed();
            //additional code
        }else if(count == 1){
            finish();
        }
        else{
            fragmentManager.popBackStack();
         }
    }

    @Override
    public void onFragmentAttached() {
        super.onFragmentAttached();
    }

    @Override
    public void onFragmentDetached(String tag) {
        Log.e("Detached:- " , ""+tag);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentByTag(tag);
//        if (fragment != null) {
//            fragmentManager
//                    .beginTransaction()
//                    .disallowAddToBackStack()
//                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
//                    .remove(fragment)
//                    .commitNow();
//            unlockDrawer();
//        }
    }

    @Override
    public void OpenImageListFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.fragment_container, ImageListFragment.newInstance(), ImageListFragment.TAG)
                .commit();

    }

    @Override
    public void OpenAddImageFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .addToBackStack(null)
                .replace(R.id.fragment_container, SelectImageFragment.newInstance(), SelectImageFragment.TAG)
                .commit();

    }

    @Override
    public void OpenMapFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .addToBackStack(null)
                .replace(R.id.fragment_container, MapFragment.newInstance(), MapFragment.TAG)
                .commit();
    }

    @Override
    public void OpenContactsFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .addToBackStack(null)
                .replace(R.id.fragment_container, ContactsFragment.newInstance(), ContactsFragment.TAG)
                .commit();
    }

    @Override
    public void closeNavigationDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(Gravity.START);
        }
    }

    @Override
    public void lockDrawer() {
        if (drawerLayout != null)
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void unlockDrawer() {
        if (drawerLayout != null)
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
}
