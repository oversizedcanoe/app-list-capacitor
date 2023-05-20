package com.oversizedcanoe.plugins.applistcapacitor;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class AppList {

    private Activity activity;
    public AppList(Activity activity){
        this.activity = activity;
    }
    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public List<AppInfo> getInstalledApps() {
        List<AppInfo> list = new ArrayList<AppInfo>();

        final Context context = this.activity.getApplicationContext();
        final PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> applicationInfos = packageManager.getInstalledApplications(0);
        int size = 0;
        for (ApplicationInfo app : applicationInfos) {
            String appName = app.loadLabel(packageManager).toString();
            list.add(size, new AppInfo(appName));
            size++;
        }
        return list;
    }
}

