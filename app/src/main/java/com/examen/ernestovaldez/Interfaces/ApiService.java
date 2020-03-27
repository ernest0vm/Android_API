package com.examen.ernestovaldez.Interfaces;

import com.examen.ernestovaldez.Models.AvailableResponse;
import com.examen.ernestovaldez.Models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    //@Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST("asociado/login")
    Call<LoginResponse> login(
            @Field("correo") String email,
            @Field("password") String password
    );

    @GET("dhl/disponibles")
    Call<AvailableResponse> getDHLAvailables(
            @Header("Authorization") String token
    );

}
