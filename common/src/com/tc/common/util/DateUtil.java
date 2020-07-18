package com.tc.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mr. Li xiaogao 2020-05-30 7:17
 * 日期工具类
 */
public class DateUtil {
    /**
     * 将指定的日期按照指定的格式 格式化为字符串
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date,String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }


    /**
     * 将日期字符串按照指定的格式解析为日期对象
     * @param dateString
     * @param format
     * @return
     */
    public static Date parse(String dateString,String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
