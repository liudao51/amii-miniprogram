/**
 * TODO: 日志工具类
 *
 * @author jewel.liu
 * @since 1.0, Sep 10, 2018
 */
package com.amii.miniprogram.api.util;

public class LogToolkit
{
    /**
     * TODO: 记录异常到日志
     *
     * @param e
     */
    public static void saveToLog (Exception e)
    {
        e.printStackTrace();
    }

    /**
     * TODO: 输出信息日志(调试专用)
     *
     * @param content
     */
    public static void mlog (String content)
    {
        if ("true".equals(ConfigToolkit.getProperty("app_mlogEnable").toLowerCase())) {
            mlog(content, true);
        } else {
            mlog(content, false);
        }
    }

    /**
     * TODO: 输出信息日志(调试专用)
     *
     * @param content
     */
    public static void mlog (String content, Boolean enable)
    {
        if (enable) {
            System.out.println("");
            System.out.println(content);
        }
    }
}