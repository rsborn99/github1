package com.airwallex.util;
import java.io.*;
import java.util.Properties;

/**
 *
 * @author juweiwei
 * @version $Id PropertiesUtil.java  v0.1 2018.12.23 22:28:41 juweiwei Exp$
 */
public class PropertiesUtil {

    private static Properties props;
    static {
        loadProps();
    }

    synchronized static private void loadProps(){
        System.out.println("begin load properties...");
        props = new Properties();
        InputStream in = null;
        try {
            File file = new File("src/test/resources/config/config.properties");
            in = new FileInputStream(file);
            props.load(in);
        } catch (FileNotFoundException e) {
            System.out.println("properties not found");
        } catch (IOException e) {
            System.out.println("IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("properties cannot be closed");
            }
        }
        System.out.println("load properties complete...........");
        System.out.println("properties content:" + props);
    }

    /**
     * getPropertyByKey
     */
    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getURL(){
        if (getProperty("test_mode").equalsIgnoreCase("dev")){
            return getProperty("dev_url");
        }else {
            return getProperty("test_url");
        }
    }
}