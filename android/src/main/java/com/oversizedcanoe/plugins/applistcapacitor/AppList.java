package com.oversizedcanoe.plugins.applistcapacitor;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class AppList {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public List<AppInfo> getInstalledApps() {
        List<AppInfo> list = new ArrayList<AppInfo>();
        list.add(0, new AppInfo("App 1"));
        list.add(1, new AppInfo("App 2"));
        list.add(2, new AppInfo("App 3"));
        return list;
    }
}

