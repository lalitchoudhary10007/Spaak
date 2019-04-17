package com.lalit.spaak_demo.data.Network;

import com.androidnetworking.common.ANRequest;

import java.util.HashMap;


public interface ApiHelper {

    ANRequest LoginApiCall(HashMap<String,String> request_login);

}
