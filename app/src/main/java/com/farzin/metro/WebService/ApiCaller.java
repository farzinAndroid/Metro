package com.farzin.metro.WebService;

import android.util.Log;

import com.farzin.metro.model.Lines;
import com.farzin.metro.model.Stations;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {
    //ارتباط بین کلاس های ApiClient و MetroService در این کلاس است

    MetroService metroService;

    public ApiCaller() {
        metroService = ApiClient.getClients().create(MetroService.class);
    }

    //صدا زدن لیست خط ها
    public void callGetLines(MessageListener listener){

        Call<List<Lines>> call = metroService.getLines();
        call.enqueue(new Callback<List<Lines>>() {
            @Override
            public void onResponse(Call<List<Lines>> call, Response<List<Lines>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Lines>> call, Throwable t) {
                Log.e("", "");
                listener.onError(t.getMessage().toString());
            }
        });
    }


    public void callGetStations(int lineId, MessageListener listener){

        Call<List<Stations>> call = metroService.getStationsByLines(lineId);

        call.enqueue(new Callback<List<Stations>>() {
            @Override
            public void onResponse(Call<List<Stations>> call, Response<List<Stations>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Stations>> call, Throwable t) {
                listener.onError(t.getMessage().toString());
            }
        });
    }
}
