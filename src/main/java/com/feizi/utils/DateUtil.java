package com.feizi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * Created by feizi on 2017/7/23.
 */
public final class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当前日期
     * @return
     */
    public static String getCurrentDate(){
        String dateStr = sdf.format(new Date());
        return dateStr;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDate());
    }
}
