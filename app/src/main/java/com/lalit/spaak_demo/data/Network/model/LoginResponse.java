package com.lalit.spaak_demo.data.Network.model;

public class LoginResponse {


    /**
     * status : true
     * result : {"token":"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxLCJpYXQiOjE1NTU0MDA1NzksImV4cCI6MTU1NTQwMTU3OX0.hqsK3l8ytFrxiT9NvCZ7M2siTpbeS6nffoiH3AkfJLQ","user":{"id":1,"role_id":4,"firstname":"Super","lastname":"Admin","dob":"01/10/2014","gender":"Male","email":"admin@gmail.com","phone":"9874589653","password":"$2b$10$6XJGf3eWUGK.APSSQPYtxuiJS/edTGz/Ep2xXW190eF6ue5wj81Pm","logdate":null,"lognum":null,"uuid":"f0482490-a767-11e8-8314-81c5a602d3db","is_active":true,"extra":null,"rp_token":null,"rp_token_created_at":null,"createdAt":"2018-08-24T06:35:48.000Z","updatedAt":"2018-08-24T06:35:48.000Z"}}
     */

    private boolean status;
    private ResultBean result;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * token : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxLCJpYXQiOjE1NTU0MDA1NzksImV4cCI6MTU1NTQwMTU3OX0.hqsK3l8ytFrxiT9NvCZ7M2siTpbeS6nffoiH3AkfJLQ
         * user : {"id":1,"role_id":4,"firstname":"Super","lastname":"Admin","dob":"01/10/2014","gender":"Male","email":"admin@gmail.com","phone":"9874589653","password":"$2b$10$6XJGf3eWUGK.APSSQPYtxuiJS/edTGz/Ep2xXW190eF6ue5wj81Pm","logdate":null,"lognum":null,"uuid":"f0482490-a767-11e8-8314-81c5a602d3db","is_active":true,"extra":null,"rp_token":null,"rp_token_created_at":null,"createdAt":"2018-08-24T06:35:48.000Z","updatedAt":"2018-08-24T06:35:48.000Z"}
         */

        private String token;
        private UserBean user;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : 1
             * role_id : 4
             * firstname : Super
             * lastname : Admin
             * dob : 01/10/2014
             * gender : Male
             * email : admin@gmail.com
             * phone : 9874589653
             * password : $2b$10$6XJGf3eWUGK.APSSQPYtxuiJS/edTGz/Ep2xXW190eF6ue5wj81Pm
             * logdate : null
             * lognum : null
             * uuid : f0482490-a767-11e8-8314-81c5a602d3db
             * is_active : true
             * extra : null
             * rp_token : null
             * rp_token_created_at : null
             * createdAt : 2018-08-24T06:35:48.000Z
             * updatedAt : 2018-08-24T06:35:48.000Z
             */

            private int id;
            private int role_id;
            private String firstname;
            private String lastname;
            private String dob;
            private String gender;
            private String email;
            private String phone;
            private String password;
            private Object logdate;
            private Object lognum;
            private String uuid;
            private boolean is_active;
            private Object extra;
            private Object rp_token;
            private Object rp_token_created_at;
            private String createdAt;
            private String updatedAt;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRole_id() {
                return role_id;
            }

            public void setRole_id(int role_id) {
                this.role_id = role_id;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public String getDob() {
                return dob;
            }

            public void setDob(String dob) {
                this.dob = dob;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getLogdate() {
                return logdate;
            }

            public void setLogdate(Object logdate) {
                this.logdate = logdate;
            }

            public Object getLognum() {
                return lognum;
            }

            public void setLognum(Object lognum) {
                this.lognum = lognum;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public boolean isIs_active() {
                return is_active;
            }

            public void setIs_active(boolean is_active) {
                this.is_active = is_active;
            }

            public Object getExtra() {
                return extra;
            }

            public void setExtra(Object extra) {
                this.extra = extra;
            }

            public Object getRp_token() {
                return rp_token;
            }

            public void setRp_token(Object rp_token) {
                this.rp_token = rp_token;
            }

            public Object getRp_token_created_at() {
                return rp_token_created_at;
            }

            public void setRp_token_created_at(Object rp_token_created_at) {
                this.rp_token_created_at = rp_token_created_at;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
