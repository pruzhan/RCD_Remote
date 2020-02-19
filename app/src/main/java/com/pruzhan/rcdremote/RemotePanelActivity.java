package com.pruzhan.rcdremote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;

public class RemotePanelActivity extends AppCompatActivity {

    private Button backButton, goToMainButton, outputsButton;
    private Intent backIntent, outputsIntent;
    private MainApplicationComponent applicationComponent;
    private DevicesParser devicesParser;
    private DevicesList devicesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remotepanel_layout);
        applicationComponent = ((App) getApplication()).getApplicationComponent();
        goToMainButton = findViewById(R.id.buttonGoToMain);
        goToMainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickGoToMainButton();
            }
        });
        backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickBackButton();
            }
        });
        outputsButton = findViewById(R.id.outputs);
        outputsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOutputsButton();
            }
        });
        devicesParser = applicationComponent.getDevicesParser();
        devicesList = applicationComponent.getDevicesList();
    }

    protected void onClickGoToMainButton() {
        XmlPullParser xpp = getResources().getXml(R.xml.elsysconfig);
        if (devicesParser.parse(xpp)) {
            for (Devices prod : devicesList.getOuts()) {
                Log.d("XML", prod.toString());
            }
            for (Devices prod : devicesList.getInputs()) {
                Log.d("XML", prod.toString());
            }
        }
    }

    protected void onClickBackButton() {
        backIntent = new Intent(this, LoginActivity.class);
        startActivity(backIntent);
        onDestroy();
    }

    protected void onClickOutputsButton() {
        outputsIntent = new Intent(this, OutputsActivity.class);
        startActivity(outputsIntent);
    }
}
