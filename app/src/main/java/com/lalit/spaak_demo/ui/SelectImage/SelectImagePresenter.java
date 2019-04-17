package com.lalit.spaak_demo.ui.SelectImage;

import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;
import com.lalit.spaak_demo.ui.ImageList.ImageListMvpPresenter;
import com.lalit.spaak_demo.ui.ImageList.ImageListMvpView;

import javax.inject.Inject;

public class SelectImagePresenter<V extends SelectImageMvpView> extends BasePresenter<V> implements SelectImageMvpPresenter<V> {

    @Inject
    public SelectImagePresenter(DataManager dataManager) {
        super(dataManager);
    }






}
