package com.lalit.spaak_demo.ui.Main;

import com.lalit.spaak_demo.ui.Base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onDrawerOptionImageListClick();

    void onDrawerOptionSelectImageClick();

    void onDrawerMapClick();

    void onDrawerMyContactsClick();

    void onViewInitialized();

    void onNavMenuCreated();

}
