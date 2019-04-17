package com.lalit.spaak_demo.data.Network;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.lalit.spaak_demo.data.prefs.AppPreferencesHelper;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
public class AppApiHelper implements ApiHelper{

    private AppPreferencesHelper mPrefernceHelper;
    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader,AppPreferencesHelper mPrefernceHelper) {
        mApiHeader = apiHeader;
        this.mPrefernceHelper=mPrefernceHelper;

    }

    @Override
    public ANRequest LoginApiCall(HashMap<String, String> request_login) {

       return AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIIN)
                .addBodyParameter(request_login) // posting java object
                .setTag("test")
                .addHeaders("x-api-key" , "MBCA19PTVAPP")
                .setPriority(Priority.MEDIUM)
                .build();

    }



}
