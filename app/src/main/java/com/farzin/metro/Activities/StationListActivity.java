package com.farzin.metro.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.farzin.metro.Adapters.StationsRVAdapter;
import com.farzin.metro.Utils.AppConfig;
import com.farzin.metro.WebService.ApiCaller;
import com.farzin.metro.WebService.MessageListener;
import com.farzin.metro.databinding.ActivityStationListBinding;
import com.farzin.metro.model.Lines;
import com.farzin.metro.model.Stations;

import java.util.List;

public class StationListActivity extends AppCompatActivity {

    ActivityStationListBinding binding;
    Bundle bundle;
    ApiCaller apiCaller;
    int lineID;

    AppConfig appConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appConfig = new AppConfig(getApplicationContext());
        startBinding();
        getExtras();
        appConfig.setTitle(bundle.getString("title_persian"));
        appConfig.setEnglishTitle(bundle.getString("title_english"));
        appConfig.setLineID(bundle.getInt("id"));


        binding.linearBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        binding.progressCircular.setVisibility(View.VISIBLE);
        apiCaller = new ApiCaller();
        apiCaller.callGetStations(lineID, new MessageListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("", "");

                binding.progressCircular.setVisibility(View.GONE);

                binding.rv.setAdapter(new StationsRVAdapter((List<Stations>) responseMessage,getApplicationContext()));
                binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("", "");
                binding.progressCircular.setVisibility(View.GONE);
            }
        });






    }



    //دریافت کردن اطلاعات از اکتیویتی اصلی
    private void getExtras() {
        bundle = getIntent().getExtras();

        if (bundle != null){
            lineID = bundle.getInt("id");
            binding.persianTitle.setText(bundle.getString("title_persian"));
            binding.enTitle.setText(bundle.getString("title_english"));
        }
    }



    //view binding
    private void startBinding() {

        binding = ActivityStationListBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }


}