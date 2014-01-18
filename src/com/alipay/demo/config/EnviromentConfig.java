/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import com.alipay.demo.bean.ToStringBase;

/**
 * 环境配置
 * 
 * @author jie.hua@alipay.com
 * @version $Id: EnviromentConfig.java, v 0.1 2014-1-16 上午9:17:44 jie.hua Exp $
 */
public class EnviromentConfig extends ToStringBase {

    /** 序列号ID  */
    private static final long    serialVersionUID = -6235945319090595835L;
    /**
     * 支付宝环境类型
     */
    private AlipayEnviromentType alipayEnviromentType;

    /**
     * Getter method for property <tt>alipayEnviromentType</tt>.
     * 
     * @return property value of alipayEnviromentType
     */
    public AlipayEnviromentType getAlipayEnviromentType() {
        return alipayEnviromentType;
    }

    /**
     * Setter method for property <tt>alipayEnviromentType</tt>.
     * 
     * @param alipayEnviromentType value to be assigned to property alipayEnviromentType
     */
    public void setAlipayEnviromentType(AlipayEnviromentType alipayEnviromentType) {
        this.alipayEnviromentType = alipayEnviromentType;
    }

}
