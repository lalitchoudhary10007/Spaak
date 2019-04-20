package com.lalit.spaak_demo.data;

import android.content.Context;
import android.net.Uri;


import com.androidnetworking.common.ANRequest;
import com.lalit.spaak_demo.data.Network.ApiHelper;
import com.lalit.spaak_demo.data.Network.model.ImageUploadResponse;
import com.lalit.spaak_demo.data.db.DbHelper;
import com.lalit.spaak_demo.data.prefs.PreferencesHelper;
import com.lalit.spaak_demo.di.ApplicationContext;

import org.json.JSONObject;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.RequestBody;
import retrofit2.Call;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;


    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public void updateApiHeader(String userId, String accessToken) {

    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public void updateUserInfo(String accessToken, String userId, LoggedInMode loggedInMode, String userName, String email, String refreshToken) {

            setAccessToken(accessToken);
            setCurrentUserId(userId);
            setCurrentUserLoggedInMode(loggedInMode);
            setCurrentUserName(userName);
            setCurrentUserEmail(email);
            setRefreshToken(refreshToken);

            updateApiHeader(userId, accessToken);

    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public String getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(String userId) {
       mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public String getRefreshToken() {
        return mPreferencesHelper.getRefreshToken();
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        mPreferencesHelper.setRefreshToken(refreshToken);
    }


    @Override
    public ANRequest LoginApiCall(HashMap<String, String> request_login) {
        return mApiHelper.LoginApiCall(request_login);
    }

    @Override
    public ANRequest GetAllImages(String pageNo) {
        return mApiHelper.GetAllImages(pageNo);
    }

//    @Override
//    public Call<ImageUploadResponse> uploadImage(RequestBody file, RequestBody desc, RequestBody eventBody, String filePath, Uri fileUri) {
//        return null;
//    }


}
