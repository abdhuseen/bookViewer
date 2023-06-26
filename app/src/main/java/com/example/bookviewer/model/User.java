package com.example.bookviewer.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userid")
    private  int   userId;
    @SerializedName("username")
    private String userName;
    @SerializedName("useremail")
    private String userEmail;
    @SerializedName("userpassword")
    private String userPassword;
    @SerializedName("userphone")
    private String userPhone;
    @SerializedName("userqueryresult")
    private boolean result;//store query result



    public User(int userId, String userName, String userEmail, String userPassword, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }
    public boolean isResult() {
        return result;
    }
}
