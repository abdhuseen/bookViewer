package com.example.bookviewer.controller.apisUrl;

import com.example.bookviewer.model.Book;
import com.example.bookviewer.model.FavoriteBook;
import com.example.bookviewer.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String checkUserUrl="http://10.0.2.2/bookViewerAppServer/checkUser.php/";
    String addUserUrl="http://10.0.2.2/bookViewerAppServer/addNewUser.php/";
    String updateUserUrl="http://10.0.2.2/bookViewerAppServer/updateUser.php/";
    String checkEmailUrl="http://10.0.2.2/bookViewerAppServer/checkEmail.php/";
    String checkPhoneUrl="http://10.0.2.2/bookViewerAppServer/checkPhone.php/";
    String deleteUserUrl="http://10.0.2.2/bookViewerAppServer/deleteUser.php/";
    String readAllbooks="http://10.0.2.2/bookViewerAppServer/ReadAllBooks.php/";
    String readBooksByType="http://10.0.2.2/bookViewerAppServer/ReadBooksByType.php/";
    String readFavBooks="http://10.0.2.2/bookViewerAppServer/ReadFavBooks.php/";
    String addFav="http://10.0.2.2/bookViewerAppServer/addFav.php/";
    String deleteFav="http://10.0.2.2/bookViewerAppServer/deleteFav.php/";
    @FormUrlEncoded
    @POST("checkUser.php")
    Call<List<User>>checkUser(@Field("email")String email,@Field("userPassword") String password);
    @FormUrlEncoded
    @POST("addNewUser.php")
    Call<List<User>>addUser(@Field("email")String email,@Field("userName")String username,@Field("phone")String phone
    ,@Field("userPassword")String password);
    @FormUrlEncoded
    @POST("updateUser.php")
    Call<List<User>>updateUser(@Field("id")int id,@Field("email")String email,@Field("userName")String userName,@Field("phone")String phone,@Field("userPassword")String password);
    @FormUrlEncoded
    @POST("checkEmail.php")
    Call<List<User>>checkEmail(@Field("email")String email);
    @FormUrlEncoded
    @POST("checkPhone.php")
    Call<List<User>>checkPhone(@Field("phone")String phone);
    @FormUrlEncoded
    @POST("deleteUser.php")
    Call<List<User>>deleteUser(@Field("id")int id);
    @GET("ReadAllBooks.php")
    Call<List<Book>>getAllBooks();
    @FormUrlEncoded
    @POST("ReadBooksByType.php")
    Call<List<Book>>getBooksByType(@Field("booktype") String bookType);
    @FormUrlEncoded
    @POST("ReadFavBooks.php")
    Call<List<Book>>getFavBooks(@Field("userid") int userid);
    @FormUrlEncoded
    @POST("addFav.php")
    Call<List<FavoriteBook>>addFavorite(@Field("userid")int userid,@Field("bookid") int bookid);
    @FormUrlEncoded
    @POST("deleteFav.php")
    Call<List<FavoriteBook>>deleteFavorite(@Field("userid") int userid,@Field("bookid") int bookid);

}
