package com.example.bookviewer.controller.adapter;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.bookviewer.R;
import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.example.bookviewer.controller.sharedPreferencesManger.SharedPreferencesManger;
import com.example.bookviewer.model.Book;
import com.example.bookviewer.model.FavoriteBook;
import com.example.bookviewer.view.activites.MainActivity;
import com.example.bookviewer.view.activites.fragments.ViewBookFragment;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class BookCardAdapter extends BaseAdapter {
    Context context;
    List<Book>booksData;
    LayoutInflater inflater;
    public BookCardAdapter(Context context, List<Book> booksData) {
        this.context = context;
        this.booksData = booksData;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return booksData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.book_card,parent,false);
        TextView bookName=convertView.findViewById(R.id.favbookName2);
        ImageView bookImage=convertView.findViewById(R.id.favbookImage2);
        CardView bookCardView=convertView.findViewById(R.id.BookCardView);
        Button download,fav;
        download=convertView.findViewById(R.id.downloadButton2);
        fav=convertView.findViewById(R.id.deletefavButton);
        bookName.setText(booksData.get(position).getBookName().toString());
        Glide.with(this.context).load("http://10.0.2.2/bookViewerAppServer/uploads/"+booksData.get(position).getBookImageLink())
                .apply(new RequestOptions().override(200,200))
                .error(R.drawable.notfound)
                .into(bookImage);
        bookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                Fragment viewBookFragment = new  ViewBookFragment();
                String BookName,AuthorName,Year,ImgLink,Description;
                BookName=booksData.get(position).getBookName();
                AuthorName=booksData.get(position).getBookAuthor();
                Year=booksData.get(position).getBookYear();
                ImgLink=booksData.get(position).getBookImageLink();
                Description=booksData.get(position).getBookDescription();
                Bundle bundle=new Bundle();
                bundle.putString("BName",BookName);
                bundle.putString("BAuthor",AuthorName);
                bundle.putString("BYear",Year);
                bundle.putString("BImgLink",ImgLink);
                bundle.putString("BDesc",Description);
              // Fragment viewBookFragment=new ViewBookFragment();
               if(viewBookFragment!=null){
                   viewBookFragment.setArguments(bundle);
                   activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,viewBookFragment).addToBackStack(null).commit();

               }



            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid= SharedPreferencesManger.getInstance(v.getContext()).getUsers().getUserId();
                int bookid=booksData.get(position).getBookId();
                Call<List<FavoriteBook>> call= AppRetrofit.getInstance("addfav").getBookViewerApi().addFavorite(userid,bookid);
                call.enqueue(new Callback<List<FavoriteBook>>() {
                    @Override
                    public void onResponse(Call<List<FavoriteBook>> call, Response<List<FavoriteBook>> response) {
                        if(response.body().get(0).isResult()){
                            Toast.makeText(v.getContext(), "AddedToFavorite", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<FavoriteBook>> call, Throwable t) {

                    }
                });
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String url="http://10.0.2.2/bookViewerAppServer/booksURL/"+booksData.get(position).getBookUrl();
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

            }
        });

       return convertView;
    }

}

