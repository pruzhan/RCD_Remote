package com.pruzhan.rcdremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

class MainActivityController {

    private final Activity activity;
    private ImageView mainImage;
    private final Button infoButton, remoteButton, mapButton;
    private Intent remoteIntent, mapIntent, infoIntent;

    MainActivityController(Activity mainActivity, Bundle bundle) {
        activity = mainActivity;
        mainImage = activity.findViewById(R.id.mainImageView);
        mainImage.setImageResource(R.drawable.elsys_mb_net_l);
        infoButton = activity.findViewById(R.id.infoButton);
        remoteButton = activity.findViewById(R.id.remoteButton);
        mapButton = activity.findViewById(R.id.mapButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onInfoButtonClicked();
            }
        });
        remoteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRemoteButtonClicked();
            }
        });
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onMapButtonClicked();
            }
        });
    }

    private void onInfoButtonClicked() {
        infoIntent = new Intent(activity, InfoActivity.class);
        activity.startActivity(infoIntent);
    }

    private void onRemoteButtonClicked() {
        remoteIntent = new Intent(activity, LoginActivity.class);
        activity.startActivity(remoteIntent);
    }

    private void onMapButtonClicked() {
        mapIntent = new Intent(activity, MapActivity.class);
        activity.startActivity(mapIntent);
    }
}
