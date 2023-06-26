package com.example.bookviewer.view.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookviewer.R;
import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.example.bookviewer.model.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextInputLayout userEmail,userName,userPhone,userPassword,confirmPassword;
        Button createAccount=findViewById(R.id.createAccountButton);
        userEmail=findViewById(R.id.SignUpEmailTextField);
        userName=findViewById(R.id.userNameTextField);
        userPhone=findViewById(R.id.phoneTextField);
        userPassword=findViewById(R.id.SignUpPasswordTextField);
        confirmPassword=findViewById(R.id.SignUpConfirmPasswordTextField);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=userEmail.getEditText().getText().toString().trim();
                String  user_name=userName.getEditText().getText().toString().trim();
                String phone=userPhone.getEditText().getText().toString().trim();
                String password=userPassword.getEditText().getText().toString().trim();
                String confirm_password=confirmPassword.getEditText().getText().toString().trim();
                if(isEmailValid(email)&&isUserNameValid(user_name)&&isPhoneValid(phone)&&isPasswordValid(password)&&isPasswordValid(confirm_password)){
                    if(password.equals(confirm_password)){
                        Call<List<User>>call= AppRetrofit.getInstance("add").getBookViewerApi().addUser(email,user_name,phone,password);
                        call.enqueue(new Callback<List<User>>() {
                            @Override
                            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                                List<User>getInsertQueryResult=response.body();
                                if(getInsertQueryResult.get(0).isResult()){
                                    Toast.makeText(SignUpActivity.this, "account created successfully", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(),LogInActivity.class));
                                }else if(getInsertQueryResult.get(0).getUserId()==-2) {
                                    Toast.makeText(SignUpActivity.this, "this account already exist", Toast.LENGTH_LONG).show();

                                }else {
                                    Toast.makeText(SignUpActivity.this, "something get wrong", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<List<User>> call, Throwable t) {

                            }
                        });
                    }else{
                        Toast.makeText(SignUpActivity.this, "check if  confirm password identical with password ", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    // get error based on specific field
                    if(!isEmailValid(email)){
                        userEmail.setError("InValidEmail(not in email form) or empty field");
                    }else if(!isUserNameValid(user_name)){
                        userName.setError("InValid UserName(start with number) or empty field");
                    }else if(!isPhoneValid(phone)){
                        userPhone.setError("InValid phone number(more than 10 digits or less than 10 digits) or empty field");
                    }else if(!isPasswordValid(password)){
                        userPassword.setError("InValid password (more than 20 character)  or empty field");
                    }else {
                       confirmPassword.setError("InValid password (more than 20 character)  or empty field");
                    }
                }
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
    private boolean isUserNameValid(String userName){
        //check userName validity
        return (!TextUtils.isEmpty(userName));
    }
    private boolean isPhoneValid(String phone){
        //check phone validity
        return (!TextUtils.isEmpty(phone)&&phone.length()==10);
    }

}