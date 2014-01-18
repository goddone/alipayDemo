/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 
 * 支付宝结果码转换工厂
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayErrorCodeFactory.java, v 0.1 2014-1-10 下午7:48:01 jie.hua Exp $
 */
public class AlipayErrorCodeFactory {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【错误码转换】";

    /**
     * 日志
     */
    private static final Logger logger         = Logger.getLogger(AlipayErrorCodeFactory.class);

    /**
     *  支付宝errorCode -> 业务结果
     * 
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static ResultEnum convertFromAlipayResponse(String errorCode, String errorMsg) {

        LoggerUtil.info(logger, OPERATION_NAME + ",支付宝返回结果[errorCode=" + errorCode + ",errorMsg="
                                + errorMsg + "]");

        // TODO 添加转换逻辑

        return ResultEnum.SYSTEM_ERROR;

    }

}
