package com.farzin.metro.WebService;

import com.farzin.metro.Utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //کلاس ساخت رتروفیت

    public static Retrofit retrofit = null;


    public static Retrofit getClients(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
