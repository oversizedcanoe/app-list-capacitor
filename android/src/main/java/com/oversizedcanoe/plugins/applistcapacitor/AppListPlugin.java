package com.oversizedcanoe.plugins.applistcapacitor;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@CapacitorPlugin(name = "AppList")
public class AppListPlugin extends Plugin {

    private AppList implementation = new AppList();

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
