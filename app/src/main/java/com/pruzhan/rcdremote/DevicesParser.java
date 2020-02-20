package com.pruzhan.rcdremote;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

import javax.inject.Inject;

public class DevicesParser {

    private DevicesList devicesList;

    @Inject
    public DevicesParser(DevicesList devicesList) {
        this.devicesList = devicesList;
    }

    public boolean parse(XmlPullParser xpp) {
        boolean status = true;
        Devices currentDevice = null;
        boolean inEntryGroup = false;
        boolean inEntryDevice = false;
        String textValue = "";

        ArrayList<Devices> inputs = devicesList.getInputs();
        ArrayList<Devices> outs = devicesList.getOuts();
        ArrayList<Devices> readers = devicesList.getReaders();
        ArrayList<Devices> doors = devicesList.getDoors();

        inputs.clear();
        outs.clear();
        doors.clear();
        readers.clear();

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        switch (tagName.toLowerCase()) {
                            case "outs":
                            case "inputs":
                            case "readers":
                            case "doors":
                                inEntryGroup = true;
                                break;
                            case "out":
                            case "input":
                            case "reader":
                            case "door":
                                if (inEntryGroup) {
                                    inEntryDevice = true;
                                    currentDevice = new Devices();
                                    break;
                                }
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inEntryGroup) {
                            if (inEntryDevice) {
                                switch (tagName.toLowerCase()) {
                                    case "out":
                                        outs.add(currentDevice);
                                        inEntryDevice = false;
                                        break;
                                    case "input":
                                        inputs.add(currentDevice);
                                        inEntryDevice = false;
                                        break;
                                    case "reader":
                                        readers.add(currentDevice);
                                        inEntryDevice = false;
                                        break;
                                    case "door":
                                        doors.add(currentDevice);
                                        inEntryDevice = false;
                                        break;
                                    case "name":
                                        currentDevice.setName(textValue);
                                        break;
                                    case "id":
                                        currentDevice.setId(textValue);
                                        break;
                                }
                            }
                        }
                        if ("outs".equalsIgnoreCase(tagName) || "inputs".equalsIgnoreCase(tagName)
                                || "doors".equalsIgnoreCase(tagName) || "readers".equalsIgnoreCase(tagName))
                            inEntryGroup = false;
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}