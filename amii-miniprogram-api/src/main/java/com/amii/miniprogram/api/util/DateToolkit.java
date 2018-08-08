/**
 * 时间日期工具类
 *
 * @author jewel.liu
 * @since 1.0, Sep 10, 2018
 */
package com.amii.miniprogram.api.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateToolkit
{
    private DateToolkit ()
    {
    }

    /**
     * TODO: 获取当前时间戳，单位秒
     *
     * @return
     */
    public static Long getCurrentTimestamp ()
    {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * TODO: 获取当前时间戳，单位毫秒
     *
     * @return
     */
    public static Long getCurrentTimestampMs ()
    {
        return System.currentTimeMillis();
    }

    /**
     * TODO: 获取当前时间日期，"yyyy-MM-dd HH:mm:ss"
     *
     * @return
     */
    public static String getCurrentDate ()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return df.format(System.currentTimeMillis());
    }

    /**
     * TODO: 获取当前时间的年
     *
     * @return
     */
    public static Integer getCurrentYear ()
    {
        Calendar c = Calendar.getInstance();

        return c.get(Calendar.YEAR);
    }

    /**
     * TODO: 获取当前时间的月
     *
     * @return
     */
    public static Integer getCurrentMonth ()
    {
        Calendar c = Calendar.getInstance();

        return c.get(Calendar.MONTH);
    }

    /**
     * TODO: 获取当前时间的日
     *
     * @return
     */
    public static Integer getCurrentDay ()
    {
        Calendar c = Calendar.getInstance();

        return c.get(Calendar.DATE);
    }

    /**
     * TODO: 获取当前时间的时
     *
     * @return
     */
    public static Integer getCurrentHour ()
    {
        Calendar c = Calendar.getInstance();

        return c.get(Calendar.HOUR);
    }

    /**
     * TODO: 获取当前时间的分
     *
     * @return
     */
    public static Integer getCurrentMinute ()
    {
        Calendar c = Calendar.getInstance();

        return c.get(Calendar.MINUTE);
    }

    /**
     * TODO: 获取当前时间的秒
     *
     * @return
     */
    public static Integer getCurrentSecond ()
    {
        Calendar c = Calendar.getInstance();

        return c.get(Calendar.SECOND);
    }
}