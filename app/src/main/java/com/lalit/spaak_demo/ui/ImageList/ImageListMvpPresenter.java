package com.lalit.spaak_demo.ui.ImageList;

import com.lalit.spaak_demo.ui.Base.MvpPresenter;

public interface ImageListMvpPresenter<V extends ImageListMvpView> extends MvpPresenter<V> {

 void LoadImage(String page);

}
