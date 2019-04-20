package com.lalit.spaak_demo.data.Network;


import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lalit.spaak_demo.BuildConfig;
import com.lalit.spaak_demo.data.Network.model.ImageUploadResponse;
import com.lalit.spaak_demo.data.prefs.AppPreferencesHelper;
import com.lalit.spaak_demo.di.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class AppApiHelper implements ApiHelper{

    private AppPreferencesHelper mPrefernceHelper;
    private ApiHeader mApiHeader;
    private Context ctc ;


    @Inject
    public AppApiHelper(ApiHeader apiHeader,AppPreferencesHelper mPrefernceHelper, @ApplicationContext Context context) {
        mApiHeader = apiHeader;
        this.mPrefernceHelper=mPrefernceHelper;
        this.ctc = context ;

    }

    @Override
    public ANRequest LoginApiCall(HashMap<String, String> request_login) {
       return AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIIN)
                .addBodyParameter(request_login)  // posting java object
                .setTag("login")
                .addHeaders("Content-Type" , "application/json")
                .setPriority(Priority.HIGH)
                .build();

    }

    @Override
    public ANRequest GetAllImages(String pageNo) {
        return AndroidNetworking.get(ApiEndPoint.ENDPOINT_GETALLIMAGE+"{pageNumber}")
                .addPathParameter("pageNumber", pageNo)
                .setTag("GetAllImages")
                .setPriority(Priority.HIGH)
                .build();

    }




}
