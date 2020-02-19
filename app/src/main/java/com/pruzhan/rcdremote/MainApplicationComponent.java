package com.pruzhan.rcdremote;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainApplicationModule.class})
public interface MainApplicationComponent {
    DevicesList getDevicesList();
    DevicesParser getDevicesParser();
}
