package com.example.bookviewer.view.activites.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.bookviewer.R;

public class ViewBookFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_book_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView showBookName,showBookAuthor,showBookYear,showBookDescription;
        ImageView bookPhoto;
        showBookName=view.findViewById(R.id.bookName2);
        showBookAuthor=view.findViewById(R.id.AuthorName);
        showBookYear=view.findViewById(R.id.YearOfBook);
        showBookDescription=view.findViewById(R.id.DescOfBook);
        bookPhoto=view.findViewById(R.id.bookImage2);
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            String BookName,AuthorName,Year,ImgLink,Description;
            BookName=bundle.getString("BName");
            AuthorName=bundle.getString("BAuthor");
            Year=bundle.getString("BYear");
            ImgLink=bundle.getString("BImgLink");
            Description=bundle.getString("BDesc");
            showBookName.setText(BookName);
            showBookAuthor.setText(AuthorName);
            showBookYear.setText(Year);
            showBookDescription.setText(Description);
            Glide.with(view.getContext()).load("http://10.0.2.2/bookViewerAppServer/uploads/"+ImgLink)
                    .apply(new RequestOptions().override(200,200))
                    .error(R.drawable.notfound)
                    .into(bookPhoto);

        }

    }
}