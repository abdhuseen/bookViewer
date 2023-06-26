package com.example.bookviewer.view.activites.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bookviewer.R;
import com.example.bookviewer.controller.adapter.BookCardAdapter;
import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.example.bookviewer.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelfDevelopmentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.self_development_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView selfDevelopmentListView=view.findViewById(R.id.SelfDevelopmentListView);
        Call<List<Book>> call= AppRetrofit.getInstance("booksbytype").getBookViewerApi().getBooksByType("selfDevelopment");
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(response.body().get(0).isResult()){
                    selfDevelopmentListView.setAdapter(new BookCardAdapter(view.getContext(),response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });


    }
}