package com.pruzhan.rcdremote;

import dagger.Component;

@ActivityScope
@Component(modules = {OutputsActivityModule.class, OutputsActivityBindings.class},
        dependencies = {MainApplicationComponent.class})
public interface OutputsActivityComponent {
    OutputsActivity outputsActivity();
    OutputsActivityController outputsActivityController();
}