package com.farzin.metro.WebService;

import com.farzin.metro.model.Lines;
import com.farzin.metro.model.Stations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MetroService {

    //فانکشن های سرویس


    //GET Method
    @GET("getLines.php")
    Call<List<Lines>> getLines();


    //POST method
    @FormUrlEncoded
    @POST("getStations.php")
    Call<List<Stations>> getStationsByLines(@Field("id") int lineId);
}
