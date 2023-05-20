package com.oversizedcanoe.plugins.applistcapacitor;

import org.json.JSONException;
import org.json.JSONObject;

public class AppInfo {
    public AppInfo(String n) {
        this.name = n;
    }

    String name = "";

    public JSONObject ToJSONObject() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.name);

        return jsonObject;
    }
}
