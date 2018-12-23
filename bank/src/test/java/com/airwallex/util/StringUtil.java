package com.airwallex.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;
/**
 *
 * @author juweiwei
 * @version $Id StringUtil.java  v0.1 2018.12.23 12:28:11 juweiwei Exp$
 */
public class StringUtil {
    public static String getJsonString(Map<String, String> map){
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

}
