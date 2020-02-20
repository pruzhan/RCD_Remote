package com.pruzhan.rcdremote;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class MainApplicationModule {

    @Singleton
    @Provides
    DevicesList devicesList() {
        return new DevicesList(new ArrayList<Devices>(), new ArrayList<Devices>(),
                new ArrayList<Devices>(), new ArrayList<Devices>());
    }
}
