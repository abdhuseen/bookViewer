package com.example.bookviewer.view.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import  com.example.bookviewer.R;
import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.example.bookviewer.controller.sharedPreferencesManger.SharedPreferencesManger;
import com.example.bookviewer.model.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        TextInputLayout emailEditText=findViewById(R.id.emailTextField);
        TextInputLayout passwordEditText=findViewById(R.id.passwordTextField);
        Button loginButton,signButton;
        loginButton=findViewById(R.id.loginButton);
        signButton=findViewById(R.id.signUpButton);
        if(SharedPreferencesManger.getInstance(getApplicationContext()).isLogin()) {
            //check if user log in before
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEditText.getEditText().getText().toString().trim();//read useremail
                String password=passwordEditText.getEditText().getText().toString().trim();//read user password
                //send email and password to check validity
                if(isEmailValid(email)&&isPasswordValid(password)){
                       Call<List<User>>call= AppRetrofit.getInstance("").getBookViewerApi().checkUser(email,password);//query about user data
                       call.enqueue(new Callback<List<User>>() {
                           @Override
                           public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                               List<User>users=response.body();
                               //if user exist then will go to main page
                               if(users.get(0).isResult()){
                                   //user exist
                                   SharedPreferencesManger.getInstance(getApplicationContext()).userLogin(users.get(0));
                                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                               }else {
                                   //user not exist
                                   Toast.makeText(LogInActivity.this, "user not found", Toast.LENGTH_SHORT).show();
                               }
                           }

                           @Override
                           public void onFailure(Call<List<User>> call, Throwable t) {

                           }
                       });


                }else {
                    Toast.makeText(LogInActivity.this, "Email or password is empty or not valid ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to sign up to create account
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });
    }
    private  boolean isEmailValid(String email){
        //check email validity
         return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    private boolean isPasswordValid(String password){
        //check password validity
        return (!TextUtils.isEmpty(password)&&(password.length()>0&&password.length()<21));
    }
}