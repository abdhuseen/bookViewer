package com.example.bookviewer.controller.appRetrofit;

import android.renderscript.Short4;

import com.example.bookviewer.controller.apisUrl.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRetrofit {

private static AppRetrofit instance=null;
private final Api bookViewerApi;
private AppRetrofit(String apiName){
    switch (apiName) {
        case "add":
        {
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.addUserUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);

    }
    break;
        case "update":
        {
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.updateUserUrl).addConverterFactory(GsonConverterFactory.create())
                .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);

        }break;
        case "checkEmail":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.checkEmailUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        case "checkPhone":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.checkPhoneUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        case "delete":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.deleteUserUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        case "allbooks":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.readAllbooks).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        case "booksbytype":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.readBooksByType).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        case "fav":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.readFavBooks).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        case "addfav":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.addFav).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        case "deletefav":{
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.deleteFav).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }break;
        default: {
            Retrofit bookViewerRetrofit = new Retrofit.Builder().baseUrl(Api.checkUserUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();
            bookViewerApi = bookViewerRetrofit.create(Api.class);
        }
    }
}
public static synchronized AppRetrofit getInstance(String apiName){
    return instance=new AppRetrofit(apiName);
}
public Api getBookViewerApi(){
    return bookViewerApi;
}
}
