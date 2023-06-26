package com.example.bookviewer.model;

import com.google.gson.annotations.SerializedName;

public class FavoriteBook {
    @SerializedName("useridfoerign")
    private int user_id;
    @SerializedName("bookidfoerign")
    private int book_id;
    @SerializedName("isfav")
    private boolean isFav;
    @SerializedName("user_book_query_result")
    private boolean result;//store query result

    public FavoriteBook(int user_id, int book_id, boolean isFav) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.isFav = isFav;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public boolean isFav() {
        return isFav;
    }

    public boolean isResult() {
        return result;
    }
}
