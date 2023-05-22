package com.oversizedcanoe.plugins.applistcapacitor;

import android.Manifest;
import android.content.Context;
import android.util.Log;

import com.getcapacitor.App;
import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@CapacitorPlugin(name = "AppList")
public class AppListPlugin extends Plugin {

    private AppList implementation;

    @Override
    public void load() {
        implementation = new AppList(getActivity());
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getInstalledApps(PluginCall call) throws JSONException {
        if(call.getData() == null) {
            call.reject("An AppListQueryParams parameter is required.");
        }

        JSObject pluginReturnObject = new JSObject();
        JSONArray installedAppsArray = new JSONArray();

        AppListQueryParams queryParams = mapCallOptions(call);

        for (AppInfo appInfo : implementation.getInstalledApps(queryParams)) {
            JSONObject appInfoObject = appInfo.ToJSONObject();
            installedAppsArray.put(appInfoObject);
        }

        pluginReturnObject.put("installedApps", installedAppsArray);
        call.resolve(pluginReturnObject);
    }

    private AppListQueryParams mapCallOptions(PluginCall call) throws JSONException {
        AppListQueryParams queryParams = new AppListQueryParams();
        queryParams.includeSystemApps = call.getBoolean("includeSystemApps");
        queryParams.includeUpdatedSystemApps = call.getBoolean("includeUpdatedSystemApps");
        queryParams.includeIcons = call.getBoolean("includeIcons");
        return queryParams;
    }

}
