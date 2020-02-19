package com.pruzhan.rcdremote;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OutputsActivity extends AppCompatActivity {
    private OutputsActivityController controller;
    private MainApplicationComponent applicationComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationComponent = ((App) getApplication()).getApplicationComponent();
        controller = new OutputsActivityController(applicationComponent.getDevicesList(), this);
        controller.onActivityCreate();
    }
}