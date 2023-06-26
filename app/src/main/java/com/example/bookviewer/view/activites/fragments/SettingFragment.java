package com.example.bookviewer.view.activites.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookviewer.R;
import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.example.bookviewer.controller.sharedPreferencesManger.SharedPreferencesManger;
import com.example.bookviewer.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.setting_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button deleteUser=view.findViewById(R.id.deleteUserButton);
        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new AlertDialog.Builder(v.getContext()).setTitle("DeleteAccount")
                      .setMessage("you are sure to delete account ")
                      .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              //delete user
                              int id= SharedPreferencesManger.getInstance(getContext()).getUsers().getUserId();
                              Call<List<User>>call= AppRetrofit.getInstance("delete").getBookViewerApi().deleteUser(id);
                              call.enqueue(new Callback<List<User>>() {
                                  @Override
                                  public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                                      List<User>deleteQuery=response.body();
                                      if(deleteQuery.get(0).isResult()){
                                          Toast.makeText(getContext(), "AccountDeletedSuccessfully", Toast.LENGTH_SHORT).show();
                                          SharedPreferencesManger.getInstance(getContext()).logOut();
                                      }
                                  }

                                  @Override
                                  public void onFailure(Call<List<User>> call, Throwable t) {

                                  }
                              });
                          }
                      })
                      .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              dialog.dismiss();
                          }
                      }).create().show();
            }
        });
    }

}