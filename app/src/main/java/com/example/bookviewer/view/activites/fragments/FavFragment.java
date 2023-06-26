package com.example.bookviewer.view.activites.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.bookviewer.R;
import com.example.bookviewer.controller.adapter.BookCardAdapter;
import com.example.bookviewer.controller.adapter.FavBookAdapter;
import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.example.bookviewer.controller.sharedPreferencesManger.SharedPreferencesManger;
import com.example.bookviewer.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fav_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView favlistView=view.findViewById(R.id.FavBooksListView);
        int userid= SharedPreferencesManger.getInstance(view.getContext()).getUsers().getUserId();
        Call<List<Book>> call= AppRetrofit.getInstance("fav").getBookViewerApi().getFavBooks(userid);
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(response.body().get(0).isResult())
                    favlistView.setAdapter(new FavBookAdapter(view.getContext(),response.body()));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });

    }


}