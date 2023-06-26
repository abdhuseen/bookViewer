package com.example.bookviewer.view.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.bookviewer.R;
import com.example.bookviewer.controller.sharedPreferencesManger.SharedPreferencesManger;
import com.example.bookviewer.view.activites.fragments.AboutUsFragment;
import com.example.bookviewer.view.activites.fragments.ContactUsFragment;
import com.example.bookviewer.view.activites.fragments.FavFragment;
import com.example.bookviewer.view.activites.fragments.HomeFragment;
import com.example.bookviewer.view.activites.fragments.NovelsFragment;
import com.example.bookviewer.view.activites.fragments.ProfileFragment;
import com.example.bookviewer.view.activites.fragments.SelfDevelopmentFragment;
import com.example.bookviewer.view.activites.fragments.SettingFragment;
import com.example.bookviewer.view.activites.fragments.TechnologyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textview.MaterialTextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView booksNavigation=findViewById(R.id.nav_view);
        View navigationHeader=booksNavigation.getHeaderView(0);
        //show user data in the header of navigation drawer
        MaterialTextView showUserName=navigationHeader.findViewById(R.id.showUserName);
        MaterialTextView showUserEmail=navigationHeader.findViewById(R.id.showUserEmail);
        MaterialTextView showUserPhone=navigationHeader.findViewById(R.id.showUserPhone);
        showUserName.setText(SharedPreferencesManger.getInstance(getApplicationContext()).getUsers().getUserName());
        showUserEmail.setText(SharedPreferencesManger.getInstance(getApplicationContext()).getUsers().getUserEmail());
        showUserPhone.setText(SharedPreferencesManger.getInstance(getApplicationContext()).getUsers().getUserPhone());
        //set toolbar and navigation drawer by code
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomnavigationView=findViewById(R.id.bottom_navigation);
       DrawerLayout drawerLayout=findViewById(R.id.navlayout);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();//to start with all books list
        //control of bottom navigation menu when one of them selected
        bottomnavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                if(item.getItemId()==R.id.novels){
                    fragment=new NovelsFragment();

                }else if(item.getItemId()==R.id.technology){
                    fragment=new TechnologyFragment();

                }else {
                    //self-development
                   fragment=new SelfDevelopmentFragment();

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                return true;
            }
        });
      booksNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch ((item.getItemId())){
                  case R.id.nav_log_out:
                  {
                      SharedPreferencesManger.getInstance(getApplicationContext()).logOut();
                  }break;
                  case R.id.nav_about_us:{
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,new AboutUsFragment()).commit();
                  }break;
                  case R.id.nav_contact_us:{
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,new ContactUsFragment()).commit();
                  }break;
                  case R.id.nav_profile:{
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
                  }break;
                  case R.id.nav_settings:{
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,new SettingFragment()).commit();
                  }break;
                  case R.id.nav_home:{
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                  }break;
                  case R.id.nav_fav:{
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,new FavFragment()).commit();
                  }break;


              }
              return true;
          }
      });
    }
}