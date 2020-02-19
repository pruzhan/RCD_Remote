package com.pruzhan.rcdremote;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OutputsActivity extends AppCompatActivity {

    private final OutputsActivityComponent component = DaggerOutputsActivityComponent.builder()
            .outputsActivityModule(new OutputsActivityModule())
            .mainApplicationComponent(((App) getApplication()).getApplicationComponent())
            .build();

    private OutputsActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = component.outputsActivityController();
        controller.onActivityCreate();
    }
}