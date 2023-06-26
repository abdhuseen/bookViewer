package com.example.bookviewer.controller.sharedPreferencesManger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.bookviewer.model.User;
import com.example.bookviewer.view.activites.LogInActivity;

public class SharedPreferencesManger {
    //store user data when it login to do not ask user to login again
    private static final String SHARED_PREF_NAME="bookViewerSharedPref";
    private static final String KEY_ID="KeyId";
    private static final String KEY_USER_NAME="KeyUsername";
    private static final String KEY_PASSWORD="KeyPassword";
    private static final String KEY_EMAIL="KeyEmail";
    private static final String KEY_PHONE="KeyPhone";
    private static SharedPreferencesManger instance;
    private static Context context;
    private SharedPreferencesManger(Context context){
        SharedPreferencesManger.context=context;
    }
    public static synchronized SharedPreferencesManger getInstance(Context context){
        if(instance==null)
            instance=new SharedPreferencesManger(context);
        return instance;
    }
    public void userLogin(User user){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(KEY_ID,user.getUserId());
        editor.putString(KEY_USER_NAME,user.getUserName());
        editor.putString(KEY_EMAIL,user.getUserEmail());
        editor.putString(KEY_PASSWORD,user.getUserPassword());
        editor.putString(KEY_PHONE,user.getUserPhone());
        editor.apply();
    }
    public User getUsers()
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return  new User(
                sharedPreferences.getInt(KEY_ID,0),
                sharedPreferences.getString(KEY_USER_NAME,"user"),
                sharedPreferences.getString(KEY_EMAIL,"Email"),
                sharedPreferences.getString(KEY_PASSWORD,"******"),
                sharedPreferences.getString(KEY_PHONE,"00962")
        );

    }
    public boolean isLogin(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_ID,0)!=0;
    }
    public void logOut(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        context.startActivity(new Intent(context, LogInActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public void userUpdate(User user) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getUserId());
        editor.putString(KEY_USER_NAME, user.getUserName());
        editor.putString(KEY_EMAIL, user.getUserEmail());
        editor.putString(KEY_PASSWORD, user.getUserPassword());
        editor.putString(KEY_PHONE,user.getUserPhone());
        editor.apply();
    }
}
