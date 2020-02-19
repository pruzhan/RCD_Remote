package com.pruzhan.rcdremote;

import dagger.Module;
import dagger.Provides;

@ActivityScope
@Module
public class OutputsActivityModule {
    OutputsActivity activity;

    @ActivityScope
    @Provides
    OutputsActivity activity() {
        return activity;
    }
    
    @Provides
    @ActivityScope
    OutputsActivityController controller(DevicesList list,
                                         OutputsActivity activity) {
        return new OutputsActivityController(list, activity);
    }
}