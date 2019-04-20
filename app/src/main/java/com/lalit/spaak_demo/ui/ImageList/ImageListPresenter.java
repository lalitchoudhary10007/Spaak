package com.lalit.spaak_demo.ui.ImageList;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.google.gson.reflect.TypeToken;
import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;
import com.lalit.spaak_demo.ui.Base.MvpPresenter;

import javax.inject.Inject;

import okhttp3.Response;

public class ImageListPresenter<V extends ImageListMvpView> extends BasePresenter<V> implements ImageListMvpPresenter<V> {


    @Inject
    public ImageListPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void LoadImage(final String page) {
        Log.e("Load Image Run:- " , ""+page);
        getMvpView().showLoading();
        getDataManager().GetAllImages(page).getAsOkHttpResponseAndParsed(new TypeToken<ImagesResponse>() {
        }, new OkHttpResponseAndParsedRequestListener<ImagesResponse>() {
            @Override
            public void onResponse(Response okHttpResponse, ImagesResponse response) {

                Log.e("Response:- " , ""+page);
                getMvpView().hideLoading();
                getMvpView().hideKeyboard();
                getMvpView().ImagesLoaded(response);
            }

            @Override
            public void onError(ANError anError) {
                getMvpView().hideLoading();
                getMvpView().hideKeyboard();
                getMvpView().showMessage("Error");
            }
        });
    }
}
