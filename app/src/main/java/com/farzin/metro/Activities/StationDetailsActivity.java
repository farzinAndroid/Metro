package com.farzin.metro.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.farzin.metro.R;
import com.farzin.metro.Utils.AppConfig;
import com.farzin.metro.databinding.ActivityStationDetailsBinding;
import com.farzin.metro.model.Stations;

public class StationDetailsActivity extends AppCompatActivity {

    ActivityStationDetailsBinding binding;
    Bundle bundle;
    Stations stations;
    AppConfig appConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding();
        getExtras();
        setFeatures();
        setColorFeatures();

        appConfig = new AppConfig(getApplicationContext());
        binding.perLineTitle.setText(appConfig.getTitle());
        binding.enLineTitle.setText(appConfig.getEnglishTitle());
        binding.lineTxt.setText(appConfig.getLineID() + "");

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }



    //ست کردن رنگ ها بر اساس خط مترو
    private void setColorFeatures() {
        if (stations.getLineID() == 1){
            binding.linearStation.setBackgroundColor(getResources().getColor(R.color.red));
            binding.linearFeatures.setBackgroundColor(getResources().getColor(R.color.red));
        }else if(stations.getLineID() == 2){
            binding.linearStation.setBackgroundColor(getResources().getColor(R.color.blue));
            binding.linearFeatures.setBackgroundColor(getResources().getColor(R.color.blue));
        }else if(stations.getLineID() == 3){
            binding.linearStation.setBackgroundColor(getResources().getColor(R.color.lowBlue));
            binding.linearFeatures.setBackgroundColor(getResources().getColor(R.color.lowBlue));
        }else if(stations.getLineID() == 4){
            binding.linearStation.setBackgroundColor(getResources().getColor(R.color.yellow));
            binding.linearFeatures.setBackgroundColor(getResources().getColor(R.color.yellow));
        }else if(stations.getLineID() == 5){
            binding.linearStation.setBackgroundColor(getResources().getColor(R.color.green));
            binding.linearFeatures.setBackgroundColor(getResources().getColor(R.color.green));
        }else if(stations.getLineID() == 7){
            binding.linearStation.setBackgroundColor(getResources().getColor(R.color.purple));
            binding.linearFeatures.setBackgroundColor(getResources().getColor(R.color.purple));
        }
    }


    //ست کردن مقادیر امکانات
    private void setFeatures() {
        binding.persianTitle.setText(stations.getTitle());
        binding.enTitle.setText(stations.getTitleEnglish());
        binding.txtAddress.setText(stations.getAddress());
        if (stations.getAtm() == 0){
            binding.txtAtm.setTextColor(getResources().getColor(R.color.gray));
            binding.imgAtm.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getBus() == 0){
            binding.txtBus.setTextColor(getResources().getColor(R.color.gray));
            binding.imgBusStation.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getElevator() == 0){
            binding.txtLifter.setTextColor(getResources().getColor(R.color.gray));
            binding.imgLifter.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getEscalator()==0){
            binding.txtEscalator.setTextColor(getResources().getColor(R.color.gray));
            binding.imgEscalator.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getLost() == 0){
            binding.txtLost.setTextColor(getResources().getColor(R.color.gray));
            binding.imgLost.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getPhone() == 0){
            binding.txtTelephone.setTextColor(getResources().getColor(R.color.gray));
            binding.imgTelephone.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getWater() == 0){
            binding.txtWater.setTextColor(getResources().getColor(R.color.gray));
            binding.imgWater.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getParking() == 0){
            binding.txtParking.setTextColor(getResources().getColor(R.color.gray));
            binding.imgParking.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getTicket() == 0){
            binding.txtTicket.setTextColor(getResources().getColor(R.color.gray));
            binding.imgTicket.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }

        if (stations.getTaxi() == 0){
            binding.txtTaxi.setTextColor(getResources().getColor(R.color.gray));
            binding.imgTaxi.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.gray));
        }
    }



    //دریافت اطلاعات از آداپتر
    private void getExtras() {
        bundle = getIntent().getExtras();
        if (bundle != null){
            stations = bundle.getParcelable("stationDetails");
        }
    }

    //binding
    private void startBinding() {
        binding = ActivityStationDetailsBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }
}