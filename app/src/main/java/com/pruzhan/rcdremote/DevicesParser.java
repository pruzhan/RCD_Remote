package com.pruzhan.rcdremote;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class DevicesParser {

    protected ArrayList<Devices> devices;

    public DevicesParser() {
        devices = new ArrayList<>();
    }

    public ArrayList<Devices> getDevices() {
        return devices;
    }

    public boolean parse(XmlPullParser xpp) {
        boolean status = true;
        Devices currentDevice = null;
        boolean inEntryGroup = false;
        boolean inEntryDevice = false;
        String textValue = "";

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("outs".equalsIgnoreCase(tagName)) {
                            inEntryGroup = true;
                        }
                        if (inEntryGroup) {
                            if ("out".equalsIgnoreCase(tagName)) {
                                inEntryDevice = true;
                                currentDevice = new Devices();
                            }
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inEntryGroup) {
                            if (inEntryDevice) {
                                if ("out".equalsIgnoreCase(tagName)) {
                                    devices.add(currentDevice);
                                    inEntryDevice = false;
                                } else if ("name".equalsIgnoreCase(tagName)) {
                                    currentDevice.setName(textValue);
                                } else if ("id".equalsIgnoreCase(tagName)) {
                                    currentDevice.setId(textValue);
                                }
                            }
                        }
                        if ("outs".equalsIgnoreCase(tagName)) inEntryGroup = false;
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