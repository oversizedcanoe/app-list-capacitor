package com.oversizedcanoe.plugins.applistcapacitor;

import org.json.JSONException;
import org.json.JSONObject;

public class AppInfo {
    public AppInfo(String name, String description, Boolean isSystemApp, Boolean isUpdatedSystemApp, String base64Icon) {
        this.name = name;
        this.description = description;
        this.isSystemApp = isSystemApp;
        this.isUpdatedSystemApp = isUpdatedSystemApp;
        this.base64Icon = base64Icon;
    }

    String name;
    String description;
    Boolean isSystemApp;
    Boolean isUpdatedSystemApp;
    String base64Icon;

    public JSONObject ToJSONObject() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.name);
        jsonObject.put("description", this.description);
        jsonObject.put("isSystemApp", this.isSystemApp);
        jsonObject.put("isUpdatedSystemApp", this.isUpdatedSystemApp);
        jsonObject.put("base64Icon", this.base64Icon);

        return jsonObject;
    }
}
