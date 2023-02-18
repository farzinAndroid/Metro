package com.farzin.metro.Activities;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.metro.Adapters.LinesRVAdapter;
import com.farzin.metro.R;
import com.farzin.metro.Utils.Constants;
import com.farzin.metro.WebService.ApiCaller;
import com.farzin.metro.WebService.MessageListener;
import com.farzin.metro.databinding.ActivityMainBinding;
import com.farzin.metro.model.Lines;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ApiCaller apiCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        startBinding();

        setSupportActionBar(binding.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,binding.drawer,binding.toolbar, R.string.open,R.string.close);
        actionBarDrawerToggle.syncState();


        //ست کردن فونت
        Typeface typeface = Typeface.createFromAsset(getAssets(), Constants.FONTS_BHOMA);
        binding.appname.setTypeface(typeface);
        //

        binding.progressCircular.setVisibility(View.VISIBLE);
        apiCaller = new ApiCaller();
        apiCaller.callGetLines(new MessageListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("", "");

                binding.progressCircular.setVisibility(View.GONE);

                LinesRVAdapter rvAdapter = new LinesRVAdapter((List<Lines>) responseMessage,getApplicationContext());
                binding.rv.setAdapter(rvAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
                binding.rv.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("", "");
                binding.progressCircular.setVisibility(View.GONE);
            }
        });


        binding.navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.metro_item:

                        Intent intent = new Intent(getApplicationContext(),MetroGraphActivity.class);
                        startActivity(intent);

                        break;
                }

                return false;
            }
        });






    }



    private void startBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }
}