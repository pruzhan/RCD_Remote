package com.pruzhan.rcdremote;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    private WebView webInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);
        webInfo = findViewById(R.id.webBrowser);
        webInfo.loadUrl("http://www.trevog.net");
    }

}
