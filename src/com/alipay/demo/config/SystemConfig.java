/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.demo.process.in.InServiceEngine;
import com.alipay.demo.tools.LoggerUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 系统配置常量
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: SystemConfig.java, v 0.1 2014-1-5 下午9:39:26 jie.hua Exp $
 */
public class SystemConfig {

    /**
     * 操作名称
     */
    private static final String          OPERATION_NAME = "【系统配置】";

    /**
     * 日志
     */
    private static final Logger          logger         = Logger.getLogger(SystemConfig.class);

    /**
     * config配置属性
     */
    private Properties                   properties     = new Properties();

    /**
     * 配置映射
     */
    private Map<String, Config>          configMap      = new HashMap<String, Config>();

    /**
     * 环境信息缓存
     */
    private LoadingCache<String, String> typeCache      = CacheBuilder
                                                            .newBuilder()
                                                            .expireAfterAccess(5, TimeUnit.MINUTES)
                                                            .build(
                                                                new CacheLoader<String, String>() {

                                                                    @Override
                                                                    public String load(String key)
                                                                                                  throws Exception {

                                                                        return properties
                                                                            .getProperty(key);
                                                                    }

                                                                });

    /**
     * 载入配置信息
     */
    private void loadProperties() {

        URL resource = InServiceEngine.class.getResource("/");

        // 资源文件路径
        String path = resource.getPath().replace("/build/classes", "").replace("%20", " ")
            .replace("classes/", "")
                      + ("/config/config.properties").replaceFirst("/", "");

        // 载入资源
        try {
            properties.load(new FileReader(path));
        } catch (Exception e) {

            LoggerUtil.warn(logger, OPERATION_NAME + ",配置资源载入异常", e);

        }

    }

    /**
     * 载入缓存实例
     */
    private void loadCacheInstance() {

        configMap.put(AlipayEnviromentType.SANDBOX.getCode(), new SandboxConfig());
        configMap.put(AlipayEnviromentType.ONLINE.getCode(), new OnlineConfig());

    }

    /**
     * 构造器
     */
    private SystemConfig() {

        loadCacheInstance();
        loadProperties();

    }

    /**
     * 获取配置文件内容
     * 
     * @param key
     * @return
     */
    private String getConfigValue(String key) {

        try {
            return typeCache.getUnchecked(key);
        } catch (Exception e) {

            LoggerUtil.warn(logger, OPERATION_NAME + ",查询配置信息异常", e);

            return null;
        }
    }

    /**
     * 配置实例:沙箱配置or线上配置
     * 
     * @return
     */
    private Config getConfig() {

        // 根据配置文件内的值，查询环境类型
        String enviroment = getConfigValue("enviromentType");

        if (StringUtils.isBlank(enviroment)) {

            enviroment = AlipayEnviromentType.ONLINE.getCode();
        }

        //根据环境类型返回对应的配置信息
        return configMap.get(enviroment);

    }

    /**
     * 子类holder
     * 
     * @author jie.hua@alipay.com
     * @version $Id: SystemConfig.java, v 0.1 2014-1-16 上午11:38:46 jie.hua Exp $
     */
    private static class SubIntanceHolder {

        public static final SystemConfig CONFIG_INSTANCE = new SystemConfig();

    }

    /**
     * 获取当前实例
     * 
     * @return
     */
    private static SystemConfig getSystemConfigInstance() {

        return SystemConfig.SubIntanceHolder.CONFIG_INSTANCE;
    }

    /**
     * 编码格式
     * <pre>
     *   这里的编码格式是商户向支付宝发送请求或应答时的格式。
     *   支付宝目前只支持GBK格式，所以这里的编码格式是固定的。
     * </pre>
     */
    private static final String CHARSET             = "GBK";

    /**
     * 支付宝成功处理码
     */
    private static final String ALIPAY_SUCCESS_CODE = "200";

    /**
     * APP名称
     */
    private static final String APP_NAME            = "alipayDemo";

    /**
     * 支付宝字符集
     * 
     * @return
     */
    public static String getAlipayCharSet() {
        return CHARSET;
    }

    /**
     * 获取支付宝成功码
     * 
     * @return
     */
    public static String getAlipaySuccessCode() {

        return ALIPAY_SUCCESS_CODE;
    }

    /**
     * 获取域名地址
     * 
     * @return
     */
    public static String getHostUrl() {

        return getSystemConfigInstance().getConfigValue("HOST_URL") + "/" + APP_NAME;
    }

    /** 
     * @see com.alipay.demo.config.Config#getGateWay()
     */

    public static String getGateWay() {
        return getSystemConfigInstance().getConfig().getGateWay();
    }

    /** 
     * @see com.alipay.demo.config.Config#getPublicId()
     */

    public static String getPublicId() {
        return getSystemConfigInstance().getConfig().getPublicId();
    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPublicKey()
     */

    public static String getMerchantPublicKey() {
        return getSystemConfigInstance().getConfig().getMerchantPublicKey();
    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPrivateKey()
     */

    public static String getMerchantPrivateKey() {
        return getSystemConfigInstance().getConfig().getMerchantPrivateKey();
    }

    /** 
     * @see com.alipay.demo.config.Config#getAlipayPublicKey()
     */

    public static String getAlipayPublicKey() {
        return getSystemConfigInstance().getConfig().getAlipayPublicKey();
    }

    /** 
     * @see com.alipay.demo.config.Config#isCheckSign()
     */

    public static boolean isCheckSign() {
        return getSystemConfigInstance().getConfig().isCheckSign();
    }

    /** 
     * @see com.alipay.demo.config.Config#isDecrypt()
     */

    public static boolean isDecrypt() {
        return getSystemConfigInstance().getConfig().isDecrypt();
    }

    /** 
     * @see com.alipay.demo.config.Config#isSign()
     */

    public static boolean isSign() {
        return getSystemConfigInstance().getConfig().isSign();
    }

    /** 
     * @see com.alipay.demo.config.Config#isEncrypt()
     */

    public static boolean isEncrypt() {
        return getSystemConfigInstance().getConfig().isEncrypt();
    }

}
