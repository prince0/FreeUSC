package com.example.chopr.freeusc;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * This gets and feed data to the database
 * Created by Prince on 1/8/2018.
 */

public interface FreeUSCService {

    @POST("put_login_data.php")
    Call<JSONObject> createUser(@Query("first_name") String first_name, @Query("last_name") String last_name,
                                @Query("email") String email, @Query("gender") String gender);

}
