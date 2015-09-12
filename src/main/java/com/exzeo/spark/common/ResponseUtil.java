package com.exzeo.spark.common;

import org.json.JSONObject;

/**
 * Created by dhruvr on 12/9/15.
 */
public class ResponseUtil {

    public static final String SUCCESS =  success().toString();
    public static final String FAILURE =  failure().toString();

    private static JSONObject success(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "success");
        return jsonObject;
    }


    private static JSONObject failure(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "failure");
        return jsonObject;
    }

}
