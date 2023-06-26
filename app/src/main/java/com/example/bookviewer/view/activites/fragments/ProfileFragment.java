package com.example.bookviewer.view.activites.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookviewer.R;
import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.example.bookviewer.controller.sharedPreferencesManger.SharedPreferencesManger;
import com.example.bookviewer.model.User;
import com.example.bookviewer.view.activites.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextInputLayout updateEmail, updateUserName, updatePassword, updatePhone;
        Button updateProfileInfo;
        updateEmail = view.findViewById(R.id.updateEmailTextField);
        updateUserName = view.findViewById(R.id.updateUserNameTextField);
        updatePassword = view.findViewById(R.id.updatePasswordTextField);
        updatePhone = view.findViewById(R.id.updatePhoneTextField);
        updateProfileInfo = view.findViewById(R.id.updateAccountButton);
        updateEmail.getEditText().setText(SharedPreferencesManger.getInstance(getContext()).getUsers().getUserEmail());
        updateUserName.getEditText().setText(SharedPreferencesManger.getInstance(getContext()).getUsers().getUserName());
        updatePhone.getEditText().setText(SharedPreferencesManger.getInstance(getContext()).getUsers().getUserPhone());
        updatePassword.getEditText().setText(SharedPreferencesManger.getInstance(getContext()).getUsers().getUserPassword());
        updateProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = updateEmail.getEditText().getText().toString().trim();
                String userName = updateUserName.getEditText().getText().toString().trim();
                String password = updatePassword.getEditText().getText().toString().trim();
                String phone = updatePhone.getEditText().getText().toString().trim();
                if(isEmailValid(email)&&isUserNameValid(userName)&&isPasswordValid(password)&&isPhoneValid(phone)){
                 if(SharedPreferencesManger.getInstance(getContext()).getUsers().getUserEmail().equals(email)&&
                 SharedPreferencesManger.getInstance(getContext()).getUsers().getUserPhone().equals(phone)){
                     //case 1
                     update(email,userName,phone,password);

                 }else if(!SharedPreferencesManger.getInstance(getContext()).getUsers().getUserPhone().equals(phone)){
                     //check if phone exist to prevent user from use phone used by another user
                     Call<List<User>>call=AppRetrofit.getInstance("checkPhone").getBookViewerApi().checkPhone(phone);
                     call.enqueue(new Callback<List<User>>() {
                         @Override
                         public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                            List<User>checkPhone=response.body();
                            if(!checkPhone.get(0).isResult()){
                                update(email,userName,phone,password);
                            }else {
                                Toast.makeText(getContext(),"this phone used by another user",Toast.LENGTH_LONG).show();
                            }
                         }

                         @Override
                         public void onFailure(Call<List<User>> call, Throwable t) {

                         }
                     });




                 }else if(!SharedPreferencesManger.getInstance(getContext()).getUsers().getUserEmail().equals(email)){
                     //check if email exist to prevent user from use email used by another user
                     Call<List<User>>call=AppRetrofit.getInstance("checkEmail").getBookViewerApi().checkEmail(email);
                     call.enqueue(new Callback<List<User>>() {
                         @Override
                         public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                             List<User>checkEmail=response.body();
                             if(!checkEmail.get(0).isResult()){
                                 update(email,userName,phone,password);
                             }else{
                                 Toast.makeText(getContext(),"this email used by another user",Toast.LENGTH_LONG).show();
                             }

                         }

                         @Override
                         public void onFailure(Call<List<User>> call, Throwable t) {

                         }
                     });

                 }

                }else {
                    //one of fields not valid
                    // get error based on specific field
                    if(!isEmailValid(email)){
                        updateEmail.setError("InValidEmail(not in email form) or empty field");
                    }else if(!isUserNameValid(userName)){
                        updateUserName.setError("InValid UserName(start with number) or empty field");
                    }else if(!isPhoneValid(phone)){
                        updatePhone.setError("InValid phone number(more than 10 digits or less than 10 digits) or empty field");
                    }else {
                        updatePassword.setError("InValid phone number(more than 20 character) or empty field");
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
    private void update(String email,String userName,String phone,String password) {
        Call<List<User>> call = AppRetrofit.getInstance("update").getBookViewerApi()
                .updateUser(SharedPreferencesManger.getInstance(getContext()).getUsers().getUserId(),
                        email, userName, phone, password);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> updateQueryResult = response.body();
                if (updateQueryResult.get(0).isResult()) {
                    Toast.makeText(getContext(), "your profile updated successfully", Toast.LENGTH_SHORT).show();
                    SharedPreferencesManger.getInstance(getContext()).userUpdate(updateQueryResult.get(0));
                    startActivity(new Intent(getContext(), MainActivity.class));//to refresh SharedPreferences
                } else {
                    Toast.makeText(getContext(), "may email or phone you enter match with other users ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }



}