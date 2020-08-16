package com.example.baptc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.baptc.ui.ui.croplist.CropListFragment;

public class Sample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    public void trybtn(View view) {
        Intent intent = new Intent(Sample.this, CropListFragment.class);
        startActivity(intent);
        finish();
    }
}