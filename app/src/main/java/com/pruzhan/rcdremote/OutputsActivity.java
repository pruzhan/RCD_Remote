package com.pruzhan.rcdremote;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputsActivity extends AppCompatActivity {

    Spinner outputsSpinner;
    TextView selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outputs);
        outputsSpinner = findViewById(R.id.outputs_spinner);
        selection = findViewById(R.id.outputs_text_view);
        onClickOutputsSpinner();

    }


    protected void onClickOutputsSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.outputs_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        outputsSpinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position) + ", " + position;
                selection.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        outputsSpinner.setOnItemSelectedListener(itemSelectedListener);
    }
}