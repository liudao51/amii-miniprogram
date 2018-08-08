/**
 * TODO: 日志工具类
 *
 * @author jewel.liu
 * @since 1.0, Sep 10, 2018
 */
package com.amii.miniprogram.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigToolkit
{
    /**
     * TODO: 获得配置文件中的值
     *
     * @param appKey
     */
    public static String getProperty (String appKey)
    {
        // 程序内部appKey与配置文件configKey之间的映射
        Map<String, String> configMap = new HashMap<String, String>();
        configMap.put("app_debug", "app.debug");
        configMap.put("app_mlogEnable", "app.mlogEnable");
        configMap.put("app_signEnable", "app.signEnable");
        configMap.put("app_pageSize", "app.pageSize");

        String configKey = configMap.get(appKey);
        String configValue = "";

        try {
            // 使用ClassLoader加载properties配置文件,并生成对应的输入流
            Properties properties = new Properties();

            // 加载总配置文件,并取得active值
            InputStream in = ClassLoader.getSystemResourceAsStream("application.properties");
            properties.load(in);

            // 加载当前有效(active)的配置文件
            String springProfilesActive = properties.getProperty("spring.profiles.active");
            String springProfilesActiveFileName = StringToolkit.areNotEmpty(springProfilesActive)
                ? "application-" + springProfilesActive + ".properties"
                : "application.properties";
            InputStream inActive = ClassLoader.getSystemResourceAsStream(springProfilesActiveFileName);
            properties.load(inActive);

            // 获取configKey对应的configValue值
            configValue = StringToolkit.areNotEmpty(configKey) ? properties.getProperty(configKey).trim() : "";
        } catch (IOException ie) {
            LogToolkit.saveToLog(ie);
        }

        return configValue;
    }
}