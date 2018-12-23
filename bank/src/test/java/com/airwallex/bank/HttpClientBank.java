package com.airwallex.bank;

import com.airwallex.util.PropertiesUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juweiwei
 * @version $Id HttpClientBank.java  v0.1 2018.12.22 19:26:01 juweiwei Exp$
 */
public class HttpClientBank {

    private Log logger = LogFactory.getLog(this.getClass());
    private HttpClient httpClient = null;
    private HttpPost method = null;
    private String statusCode ="";
    private String isSuccess="";
    private String msg="";
    /**
     *
     *
     * @param url
     */
    public HttpClientBank(String url) {
        if (url != null) {
            httpClient = new DefaultHttpClient();
            method = new HttpPost(url);

        }
    }

    /**
     * call API
     *
     * @param parameters
     * @return
     */
    public  Map<String ,String> post(String parameters) {
        String body = null;
        logger.info("parameters:" + parameters);

        if (method != null & parameters != null
                && !"".equals(parameters.trim())) {
            try {
                method.addHeader("Content-type", "application/json; charset=utf-8");
                method.setHeader("Accept", "application/json");
                method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
                HttpResponse response = httpClient.execute(method);
                statusCode = String.valueOf(response.getStatusLine().getStatusCode());
                logger.info("statusCode:" + statusCode);
                // get response body
                body = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                // net error
                logger.error("IO ERROR:",e);
            } finally {
                logger.info("statusCode:" + statusCode);
            }

        }
        //construct map to return
        Map mapType =JSON.parseObject(body,Map.class) ;
        Map<String,String> map = new HashMap<String,String>();
        map.put("statusCode",statusCode);
        map.put("isSuccess",String.valueOf(mapType.keySet().toArray()[0]));
        map.put("msg",String.valueOf(mapType.values().toArray()[0]));

        return map;
    }
public static void main(String[] args){
        System.out.println(System.getProperties().getProperty("os.name"));
}
}
