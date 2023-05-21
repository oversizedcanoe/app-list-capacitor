package com.oversizedcanoe.plugins.applistcapacitor;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
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
            CharSequence sequence = app.loadDescription(packageManager);
            String description = sequence == null ? "" : sequence.toString();
            Boolean isSystemApp = (app.flags & ApplicationInfo.FLAG_SYSTEM)  != 0;
            Boolean isUpdatedSystemApp = (app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP)  != 0;
            String base64Icon =  Utilities.drawableToBase64String(app.loadIcon(packageManager));

            AppInfo appInfo = new AppInfo(appName, description, isSystemApp, isUpdatedSystemApp, base64Icon);

            list.add(size, appInfo);
            size++;
        }

        return list;
    }
}

