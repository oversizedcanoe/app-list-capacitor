package com.oversizedcanoe.plugins.applistcapacitor;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

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
    public void getInstalledApps(PluginCall call) {
        
        JSObject ret = new JSObject();
        ret.put("value", implementation.getInstalledApps());
        call.resolve(ret);
    }
}
