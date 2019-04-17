package com.lalit.spaak_demo.data.prefs;

import com.lalit.spaak_demo.data.DataManager;

public interface PreferencesHelper {

  int getCurrentUserLoggedInMode();

  void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

  String getCurrentUserId();

  void setCurrentUserId(String userId);

  String getCurrentUserName();

  void setCurrentUserName(String userName);

  String getCurrentUserEmail();

  void setCurrentUserEmail(String email);

  String getAccessToken();

  void setAccessToken(String accessToken);

  String getRefreshToken();

  void setRefreshToken(String refreshToken);


}
