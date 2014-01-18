/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝环境类型
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayEnviromentType.java, v 0.1 2014-1-16 上午9:18:12 jie.hua Exp $
 */
public enum AlipayEnviromentType {

    /**
     * 支付宝沙箱环境
     */
    SANDBOX("SANDBOX", "支付宝沙箱环境"),

    /**
     * 支付宝线上环境
     */
    ONLINE("ONLINE", "支付宝线上环境");

    /**
     * 映射关系
     */
    private static final Map<String, AlipayEnviromentType> cachesMap = new HashMap<String, AlipayEnviromentType>();

    static {

        for (AlipayEnviromentType type : AlipayEnviromentType.values()) {

            cachesMap.put(type.getCode(), type);
        }

    }

    /**
     * 编码
     */
    private String                                         code;

    /**
     * 描述
     */
    private String                                         msg;

    /**
     * @param code
     * @param msg
     */
    private AlipayEnviromentType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     * 
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 根据编码获取类型
     * 
     * @param code
     */
    public static AlipayEnviromentType getTypeByCode(String code) {

        return cachesMap.get(code);
    }

}
