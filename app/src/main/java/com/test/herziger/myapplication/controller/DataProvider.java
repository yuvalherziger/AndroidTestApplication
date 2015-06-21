package com.test.herziger.myapplication.controller;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
/**
 * Created by herzigery on 6/20/2015.
 */
public class DataProvider {
    private final String jsonStr = "{\"data\": [{\"id\": \"1\",\"firstName\": \"Atar\",\"lastName\": \"Herziger\",\"email\": \"atar@gmail.com\"},{\"id\": \"2\",\"firstName\": \"Yuval\",\"lastName\": \"Herziger\",\"email\": \"yuval@gmail.com\"},{\"id\": \"3\",\"firstName\": \"Taches\",\"lastName\": \"Herziger\",\"email\": \"bark.bark@gmail.com\"}]}";
    private List<HashMap<Object, String>> dataList;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public List<HashMap<String, Object>> getData() {
        List<HashMap<String, Object>> data = new ArrayList();

        // creating InputStream object for JsonReader
        InputStream is = new ByteArrayInputStream(jsonStr.getBytes(StandardCharsets.UTF_8));
        JsonReader reader = Json.createReader(is);
        JsonObject obj = reader.readObject();

        // initial "data" object, SnowPlow:
        JsonArray results = obj.getJsonArray("data");
        /*
         * iterate over JSON array and find relevant
         * element:
         */
        for (JsonValue res : results) {
            JsonObject singleElementInArray = (JsonObject) res;
            @SuppressWarnings("Convert2Diamond")
            HashMap<String, Object> row = new HashMap<String, Object>();
            row.put("id", singleElementInArray.containsKey("id") ? singleElementInArray.getString("firstName") : "N/A");
            row.put("firstName", singleElementInArray.containsKey("firstName") ? singleElementInArray.getString("firstName") : "N/A");
            row.put("lastName", singleElementInArray.containsKey("lastName") ? singleElementInArray.getString("lastName") : "N/A");
            row.put("email", singleElementInArray.containsKey("email") ? singleElementInArray.getString("email") : "N/A");
            data.add(row);
        }
        return data;
    }


}
