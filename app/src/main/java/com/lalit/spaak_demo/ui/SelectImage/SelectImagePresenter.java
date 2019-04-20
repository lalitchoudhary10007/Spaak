package com.lalit.spaak_demo.ui.SelectImage;

import android.content.Context;

import com.lalit.spaak_demo.APIs;
import com.lalit.spaak_demo.SpaakApp;
import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SelectImagePresenter<V extends SelectImageMvpView> extends BasePresenter<V> implements SelectImageMvpPresenter<V> {



    @Inject
    public SelectImagePresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void UploadImage(String path, Context ctc) {

        getMvpView().showLoading();

        Retrofit retrofit = SpaakApp.getRetrofitClient();
        APIs uploadAPIs = retrofit.create(APIs.class);
        File file = new File(path);
        RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileReqBody);
        RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "3");
        RequestBody description1 = RequestBody.create(MediaType.parse("text/plain"), "3");

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", getDataManager().getAccessToken());

        Call call = uploadAPIs.uploadImage(part, description,description1, map);
        call.enqueue(new retrofit2.Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                getMvpView().ImageUploadSuccess(response);
                getMvpView().hideLoading();
                getMvpView().showMessage("Image Uploaded Successfully !!");
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                getMvpView().showMessage("Erroe Image Upload");
                getMvpView().hideLoading();
            }
        });

    }
}
