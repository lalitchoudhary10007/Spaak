package com.lalit.spaak_demo.ui.Main;

import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {


    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void onDrawerOptionImageListClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().OpenImageListFragment();
    }

    @Override
    public void onDrawerOptionSelectImageClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().OpenAddImageFragment();
    }

    @Override
    public void onDrawerMapClick() {
          getMvpView().closeNavigationDrawer();
          getMvpView().OpenMapFragment();
    }

    @Override
    public void onDrawerMyContactsClick() {
         getMvpView().closeNavigationDrawer();
         getMvpView().OpenContactsFragment();
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void onNavMenuCreated() {

    }
}
