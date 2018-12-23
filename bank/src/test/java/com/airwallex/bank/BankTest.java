package com.airwallex.bank;

import com.airwallex.util.CSVUtil;
import com.airwallex.util.MapUtil;
import com.airwallex.util.PropertiesUtil;
import com.airwallex.util.StringUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author juweiwei
 * @version $Id BankTest.java  v0.1 2018.12.22 20:21:01 juweiwei Exp$
 */
public class BankTest {
    //getURL from propertity file
    private static String apiURL = PropertiesUtil.getURL();

    HttpClientBank httpClientBank =new HttpClientBank(apiURL);
    @DataProvider(name="bank")
    public Iterator<Object[]> Numbers() throws IOException{
        return (Iterator<Object[]>)new CSVUtil("banktest.csv");
    }
    @Test(dataProvider="bank")
    public void testBank(Map<String, String> data){
        System.out.println("request="+data);
        //1 get jsonstr for request
        String  jsonStr = StringUtil.getJsonString(MapUtil.getRequestMap(data));
        //2 post request
        Map<String,String> responseMap=httpClientBank.post(jsonStr);
        System.out.println("responseMap="+responseMap);
        //3 validate statusCode and msg
        Assert.assertEquals(responseMap.get("statusCode"),data.get("response_status"));
        Assert.assertEquals(responseMap.get("msg"),data.get("msg"));
    }
}
