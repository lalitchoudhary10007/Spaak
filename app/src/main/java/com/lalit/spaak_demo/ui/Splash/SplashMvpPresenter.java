package com.lalit.spaak_demo.ui.Splash;

import com.lalit.spaak_demo.ui.Base.MvpPresenter;

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void GetIslogin();

    void CheckPermissions();

}
