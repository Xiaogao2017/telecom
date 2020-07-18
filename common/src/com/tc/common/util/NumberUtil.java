package com.tc.common.util;

import java.text.DecimalFormat;

/**
 * @author Mr. Li xiaogao 2020-05-30 7:01
 * 数字的工具类
 */
public class NumberUtil {
    /**
     * 将数字格式化为字符串
     * @param num
     * @param length
     * @return
     */
    public static String format(int num,int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append("0");
        }
        DecimalFormat decimalFormat = new DecimalFormat(stringBuilder.toString());
        return decimalFormat.format(num);
    }

    public static void main(String[] args) {
        System.out.println(format(10,10));
    }
}
