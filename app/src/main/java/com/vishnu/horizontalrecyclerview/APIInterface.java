package com.vishnu.horizontalrecyclerview;


import com.vishnu.horizontalrecyclerview.Basic.Modulaclass;
import com.vishnu.horizontalrecyclerview.CyclerView.Class3;
import com.vishnu.horizontalrecyclerview.Diffcult.Diffcult;
import com.vishnu.horizontalrecyclerview.RecyclerView.Class;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {


    @GET("employee")
    Call<List<Modulaclass>> getDetaile();

    @FormUrlEncoded
    @POST("/api/users")
    Call<UserClass> Putdata(@Field("name") String name,@Field("job") String job);

    @GET("api/Tourist?page=1")
    Call<Codebeautify> getDataFromOnline();

    @FormUrlEncoded
    @POST("login")
    Call<Root> getLogin(
            @Field("phone") String phone,
            @Field("password") String password,
            @Field("token") String token
    );

    @GET("employee")
    Call<List<Class>> LoadFromAPi();

    @GET("photos")
    Call<List<Class3>> Load();

    @GET("users")
    Call<Diffcult> getLoad();









}
