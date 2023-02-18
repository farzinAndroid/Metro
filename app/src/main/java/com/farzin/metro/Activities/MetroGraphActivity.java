package com.farzin.metro.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.farzin.metro.R;
import com.farzin.metro.databinding.ActivityMetriGraphBinding;

public class MetroGraphActivity extends AppCompatActivity {

    ActivityMetriGraphBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding();



    }



    //binding
    private void startBinding() {
        binding = ActivityMetriGraphBinding.inflate(LayoutInflater.from(getApplicationContext()));
        View v = binding.getRoot();
        setContentView(v);
    }
}