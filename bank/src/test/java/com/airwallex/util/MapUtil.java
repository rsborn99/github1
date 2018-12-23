package com.airwallex.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juweiwei
 * @version $Id MapUtil.java  v0.1 2018.12.22 22:28:01 juweiwei Exp$
 */
public  class MapUtil {
    public static Map<String ,String> getRequestMap(Map<String, String> data){
        Map<String,String> requestMap = new HashMap<String, String>();
        requestMap.put("payment_method",data.get("payment_method"));
        requestMap.put("bank_country_code",data.get("bank_country_code"));
        requestMap.put("account_name",data.get("account_name"));
        requestMap.put("account_number",data.get("account_number"));
        requestMap.put("swift_code",data.get("swift_code"));
        requestMap.put("bsb",data.get("bsb"));
        requestMap.put("aba",data.get("aba"));
        return requestMap;
    }
}
