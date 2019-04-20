package com.lalit.spaak_demo.ui.SelectImage;

import com.lalit.spaak_demo.ui.Base.MvpView;

import retrofit2.Response;

public interface SelectImageMvpView extends MvpView {


    void ImageUploadSuccess(Response response);


}
