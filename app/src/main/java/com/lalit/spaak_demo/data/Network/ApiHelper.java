package com.lalit.spaak_demo.data.Network;

import android.net.Uri;

import com.androidnetworking.common.ANRequest;
import com.lalit.spaak_demo.data.Network.model.ImageUploadResponse;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiHelper {

    ANRequest LoginApiCall(HashMap<String,String> request_login);

    ANRequest GetAllImages(String pageNo);



}
