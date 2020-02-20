package com.pruzhan.rcdremote;

import java.util.ArrayList;

public class DevicesList {

    private final ArrayList<Devices> inputs;
    private final ArrayList<Devices> outs;
    private final ArrayList<Devices> readers;
    private final ArrayList<Devices> doors;

    public ArrayList<Devices> getOuts() {
        return outs;
    }

    public ArrayList<Devices> getInputs() {
        return inputs;
    }

    public ArrayList<Devices> getReaders() {
        return readers;
    }

    public ArrayList<Devices> getDoors() {
        return doors;
    }

    public DevicesList(ArrayList<Devices> outs, ArrayList<Devices> inputs,
                       ArrayList<Devices> readers, ArrayList<Devices> doors) {
        this.outs = outs;
        this.inputs = inputs;
        this.readers = readers;
        this.doors = doors;
    }
}
