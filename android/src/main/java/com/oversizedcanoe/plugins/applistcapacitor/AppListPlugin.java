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
        
        JSObject ret = new JSObject();

        JSONArray installedAppsArray = new JSONArray();

        for (AppInfo appInfo : implementation.getInstalledApps()) {
            
            JSONObject appInfoObject = appInfo.ToJSONObject();

            installedAppsArray.put(appInfoObject);
        }

        ret.put("installedApps", installedAppsArray);
        call.resolve(ret);
    }
}
