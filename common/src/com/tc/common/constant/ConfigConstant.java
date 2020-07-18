package com.tc.common.constant;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Mr. Li xiaogao 2020-05-31 21:13
 */
public class ConfigConstant {
    private static Map<String,String> valueMap = new HashMap<String, String>();
    static {
        //读取配置文件的方法
        ResourceBundle tc = ResourceBundle.getBundle("tc");
        Enumeration<String> keys = tc.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = tc.getString(key);
            valueMap.put(key,value);
        }
    }

    public static String getValue(String key) {
        return valueMap.get(key);
    }

    public static void main(String[] args) {
        String value = ConfigConstant.getValue("bootstrap.servers");
        System.out.println("value = " + value);
    }
}
