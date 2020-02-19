package com.pruzhan.rcdremote;

import android.app.Activity;
import android.app.Application;

public class App extends Application {
    private MainApplicationComponent applicationComponent;

    public static App get(Activity activity) {
        return (App) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerMainApplicationComponent.builder()
                .mainApplicationModule(new MainApplicationModule())
                .build();
    }

    public MainApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
