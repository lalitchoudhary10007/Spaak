package com.lalit.spaak_demo.data.Network.model;

import java.util.List;

public class LoginResponse {


    /**
     * statusCode : success
     * status : 200
     * message : Login Successful
     * accessToken : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJwcm9qZWN0cy5ib290Y2FtcC5taW5kb3Jrcy5jb20iLCJhdWQiOiJtaW5kb3Jrc19ib290Y2FtcF9zdHVkZW50cyIsInN1YiI6IjVjYjViYzhlZGRmZmNhMGIyNGZlZjU0MCIsImlhdCI6MTU1NTQxNTY3MiwiZXhwIjoxNTU4MDA3NjcyLCJwcm0iOiI3M2NlMjJiNTFmZTE0Y2Y5MzU0Y2U2YjI4ZTRjNzhhN2UyNjA5ZGEwOGY2NDcyZThmZTg2YzhhNWMxZWZlNzJmZGQwM2E4YzJhZjFmODA2M2ZjZGEyMzRjZDk0Y2IyZTY3YmM5Y2Q0ODJmMDJlZDM2YjAwZTI3YzRkY2I1MDcxZiJ9.KdOd-DweP0tsIjiY-z_IddLsZK8f2l7qPMO_FUIO8avL6nVgZIwW7iyrNw_-nJL6g6OlScF-TJ9QXkHmJEWhEA
     * refreshToken : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJwcm9qZWN0cy5ib290Y2FtcC5taW5kb3Jrcy5jb20iLCJhdWQiOiJtaW5kb3Jrc19ib290Y2FtcF9zdHVkZW50cyIsInN1YiI6IjVjYjViYzhlZGRmZmNhMGIyNGZlZjU0MCIsImlhdCI6MTU1NTQxNTY3MiwiZXhwIjoxNTY1NzgzNjcyLCJwcm0iOiIxZmQ5YWZlNWY3ZWE2NjE0ZTY3NWNiYWQ0ODQ5ZDExNWQ2YmVjOGU5YTk1MDRiZGZmNzY0MTUwM2ZjNDIwMmVhMTZhNDMxMTQ2YTgxZTdjZGUxYTNjZTBlM2IxOGI0ZDIyMzA4MDJiMDFiZjJmYjRjY2MxYjBhZWYwN2UzMmY3MyJ9.Wa7BGisX9_48KnoRGNrNRsE-teRHgWVN5YXKvaKoMTYnQaSXw56ODNzAi2bbgt8BbZ274q80kOkXM1XBTRgqwA
     * userRoles : [{"_id":"5c6075712e43da0cd67c53a9","code":"LEARNER_BOOTCAMP_BATCH_1"}]
     * userId : 5cb5bc8eddffca0b24fef540
     * userName : lalit
     * userEmail : lalitchoudhary503@gmail.com
     */

    private String statusCode;
    private int status;
    private String message;
    private String accessToken;
    private String refreshToken;
    private String userId;
    private String userName;
    private String userEmail;
    private List<UserRolesBean> userRoles;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<UserRolesBean> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRolesBean> userRoles) {
        this.userRoles = userRoles;
    }

    public static class UserRolesBean {
        /**
         * _id : 5c6075712e43da0cd67c53a9
         * code : LEARNER_BOOTCAMP_BATCH_1
         */

        private String _id;
        private String code;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
