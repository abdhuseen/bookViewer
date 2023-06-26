package com.example.bookviewer.view.activites.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.bookviewer.R;

public class ContactUsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_us_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton intsgram=view.findViewById(R.id.instgramButton);
        ImageButton whatsApp=view.findViewById(R.id.whatsappButton);
        intsgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to developer Instagram
                Intent instgram=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/eng.abdalsahory/"));
                startActivity(instgram);
            }
        });
        whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to developer whatsapp
                Intent whatsapp=new Intent(Intent.ACTION_VIEW,Uri.parse("https://wa.me/00962795410867?text=hello%2Ciam%20eng.abd%20hussen"));
                startActivity(whatsapp);
            }
        });
    }


}