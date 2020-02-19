package com.pruzhan.rcdremote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;

public class RemotePanelActivity extends AppCompatActivity {

    private Button backButton, goToMainButton, outputsButton;
    private Intent backIntent, mainIntent, outputsIntent;
    TextView LogTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remotepanel_layout);
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
    }

    protected void onClickGoToMainButton() {
        XmlPullParser xpp = getResources().getXml(R.xml.elsysconfig);
        DevicesParser parser = new DevicesParser();
        if(parser.parse(xpp))
        {
            for(Devices prod: parser.getDevices()){
                LogTextView=findViewById(R.id.logTextView);
                LogTextView.setText(prod.toString());
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
