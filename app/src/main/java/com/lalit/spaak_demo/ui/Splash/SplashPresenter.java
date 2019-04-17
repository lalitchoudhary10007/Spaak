package com.lalit.spaak_demo.ui.Splash;

import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;

import javax.inject.Inject;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void GetIslogin() {

        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getMvpView().openLoginActivity();
        } else {
            getMvpView().openMainActivity();
        }

    }

    @Override
    public void CheckPermissions() {

    }


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }





}
