package com.lalit.spaak_demo.ui.ImageList;

import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;
import com.lalit.spaak_demo.ui.Base.MvpPresenter;

import javax.inject.Inject;

public class ImageListPresenter<V extends ImageListMvpView> extends BasePresenter<V> implements ImageListMvpPresenter<V> {


    @Inject
    public ImageListPresenter(DataManager dataManager) {
        super(dataManager);
    }


}
