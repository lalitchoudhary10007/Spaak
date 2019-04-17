package com.lalit.spaak_demo.ui.Login;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.reflect.TypeToken;
import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.data.Network.model.LoginResponse;
import com.lalit.spaak_demo.ui.Base.BasePresenter;
import com.lalit.spaak_demo.utils.CommonUtils;

import java.util.HashMap;

import javax.inject.Inject;

import okhttp3.Response;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }



    @Override
    public void Login(String email, String pass) {
        getMvpView().hideKeyboard();

        if (email == null || email.isEmpty()) {
            getMvpView().onError("Enter Email");
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError("Enter valid Email");
            return;
        }
        if (pass == null || pass.isEmpty()) {
            getMvpView().onError("Enter Password");
            return;
        }


        HashMap<String,String> body_parameter=new HashMap<>();
        body_parameter.put("email",email);
        body_parameter.put("password",pass);
        getMvpView().showLoading();

        getDataManager().LoginApiCall(body_parameter).getAsOkHttpResponseAndParsed(new TypeToken<LoginResponse>(){}, new OkHttpResponseAndParsedRequestListener<LoginResponse>() {
            @Override
            public void onResponse(Response okHttpResponse, LoginResponse response) {

                getDataManager().updateUserInfo(
                        response.getAccessToken(),
                        response.getUserId(),
                        DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_IN,
                        response.getUserName(),
                        response.getUserEmail(),
                        response.getRefreshToken());


                getMvpView().showMessage("Response Success");
                getMvpView().hideLoading();
                getMvpView().hideKeyboard();
                getMvpView().OpenHome();
            }

            @Override
            public void onError(ANError anError) {
                getMvpView().hideLoading();
                getMvpView().hideKeyboard();
                handleApiError(anError);
            }
        });


    }
}
