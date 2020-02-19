package com.pruzhan.rcdremote;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {

    String[] floors = {"1 этаж", "2 этаж", "3 этаж"};
    Spinner floorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        floorSpinner = findViewById(R.id.floor);
        onClickFloorsSpinner();
    }

    private void onClickFloorsSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, floors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorSpinner.setAdapter(adapter);
    }
}
