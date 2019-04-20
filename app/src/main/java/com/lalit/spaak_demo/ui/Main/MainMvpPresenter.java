package com.lalit.spaak_demo.ui.Main;

import com.lalit.spaak_demo.ui.Base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {


    void onViewInitialized();

    void onNavMenuCreated();

}
