package com.khieuthichien.lab2;

import com.khieuthichien.lab2.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @POST("/android/login.php")
    @FormUrlEncoded
    Call<User> login(@Field("username") String username, @Field("password") String password,  @Field("name") String name);

    //lay danh sach chuyen muc
    //page la so trang bat dau tu 1
    //per_page la so phan tu muon lay
    @GET("wp-json/wp/v2/categories")
    Call<String> getCategories(@Query("page") String page, @Query("per_page") String per_page);

}
