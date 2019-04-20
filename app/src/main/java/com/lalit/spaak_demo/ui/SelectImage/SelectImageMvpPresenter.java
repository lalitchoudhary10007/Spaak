package com.lalit.spaak_demo.ui.SelectImage;

import android.content.Context;

import com.lalit.spaak_demo.ui.Base.MvpPresenter;
import com.lalit.spaak_demo.ui.ImageList.ImageListMvpView;

public interface SelectImageMvpPresenter<V extends SelectImageMvpView> extends MvpPresenter<V> {

   void UploadImage(String path, Context ctc);

}
