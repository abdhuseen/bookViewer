package com.example.bookviewer.model;

import com.example.bookviewer.controller.appRetrofit.AppRetrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Book {
    @SerializedName("bookid")
    private int bookId;
    @SerializedName("bookname")
    private String bookName;
    @SerializedName("bookauthor")
    private String bookAuthor;
    @SerializedName("bookyear")
    private String bookYear;
    @SerializedName("bookimagelink")
    private String bookImageLink;
    @SerializedName("bookdescription")
    private String bookDescription;
    @SerializedName("booktype")
    private String bookType;
    @SerializedName("bookurl")
    private String bookUrl;
    @SerializedName("bookqueryresult")
    private boolean result;//store query result

    public Book(int bookId, String bookName, String bookAuthor, String bookYear, String bookImageLink, String bookDescription, String bookType,String bookUrl) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookImageLink = bookImageLink;
        this.bookDescription = bookDescription;
        this.bookType = bookType;
        this.bookUrl=bookUrl;

    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookYear() {
        return bookYear;
    }

    public String getBookImageLink() {
        return bookImageLink;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getBookType() {
        return bookType;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public boolean isResult() {
        return result;
    }

}
