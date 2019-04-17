package com.lalit.spaak_demo.ui.Splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lalit.spaak_demo.R;
import com.lalit.spaak_demo.ui.Base.BaseActivity;
import com.lalit.spaak_demo.ui.Login.LoginActivity;
import com.lalit.spaak_demo.ui.Main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashMvpView {


    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    String[] permissions = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        mPresenter.onAttach(SplashActivity.this);

        setUp();

    }



    @Override
    protected void setUp() {

        if(checkPermissions()){
            mPresenter.GetIslogin();
        }

    }



    @Override
    public void openLoginActivity() {
      startActivity(new Intent(SplashActivity.this , LoginActivity.class));
      finish();
    }

    @Override
    public void openMainActivity() {
        startActivity(new Intent(SplashActivity.this , MainActivity.class));
        finish();
    }

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(SplashActivity.this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_CODE);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mPresenter.GetIslogin();
                } else {

                }
                return;
            }

        }}


}
