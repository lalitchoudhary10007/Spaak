package com.lalit.spaak_demo.ui.Login;

import com.lalit.spaak_demo.ui.Base.MvpPresenter;
import com.lalit.spaak_demo.ui.Splash.SplashMvpView;

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void Login(String email , String pass);
}
