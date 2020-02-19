package com.pruzhan.rcdremote;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

public class OutputsActivityController {

    private final DevicesList devicesList;
    private final OutputsActivity activity;
    private Spinner outputsSpinner;
    private TextView selection;

    @Inject
    public OutputsActivityController(DevicesList devicesList,
                                     OutputsActivity activity) {
        this.devicesList = devicesList;
        this.activity = activity;
    }

    private void onClickOutputsSpinner() {
        ArrayList<String> outsList = new ArrayList<>();
        for (Devices devices : devicesList.getOuts()) {
            outsList.add(devices.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, outsList);
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

    public void onActivityCreate() {
        activity.setContentView(R.layout.activity_outputs);
        outputsSpinner = activity.findViewById(R.id.outputs_spinner);
        selection = activity.findViewById(R.id.outputs_text_view);
        onClickOutputsSpinner();
    }
}
