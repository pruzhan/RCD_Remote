package com.pruzhan.rcdremote;

import java.util.ArrayList;

public class DevicesList {

    private final ArrayList<Devices> inputs;
    private final ArrayList<Devices> outs;

    public ArrayList<Devices> getOuts() {
        return outs;
    }

    public ArrayList<Devices> getInputs() {
        return inputs;
    }

    public DevicesList(ArrayList<Devices> outs, ArrayList<Devices> inputs) {
        this.outs = outs;
        this.inputs = inputs;
    }
}
