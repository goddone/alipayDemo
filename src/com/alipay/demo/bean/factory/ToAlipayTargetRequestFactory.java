/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;
import com.alipay.demo.response.converter.to.ToAlipayAddAccountRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayDefaultRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayMsgPushRequestConverter;
import com.alipay.demo.response.converter.to.ToAlipayRequestConverter;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 
 * 商户->支付宝实际请求工厂
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTargetRequestFactory.java, v 0.1 2014-1-11 下午3:17:58 jie.hua Exp $
 */
public class ToAlipayTargetRequestFactory {

    /**
     * 日志
     */
    private static final Logger                                                               logger    = Logger
                                                                                                            .getLogger(ToAlipayTargetRequestFactory.class);

    /**
     * 转换器映射
     */
    private static final Map<Class<? extends ToAlipayModelRequest>, ToAlipayRequestConverter> cacheMaps = new HashMap<Class<? extends ToAlipayModelRequest>, ToAlipayRequestConverter>();

    /**
     * 初始化转换器
     */
    static {

        registerConverter(new ToAlipayDefaultRequestConverter());
        registerConverter(new ToAlipayAddAccountRequestConverter());
        registerConverter(new ToAlipayMsgPushRequestConverter());
    }

    /**
     * 注册转换器
     * 
     * @param converter
     */
    private static void registerConverter(ToAlipayRequestConverter converter) {

        cacheMaps.put(converter.getSrcClass(), converter);

    }

    /**
     * 获取转换器
     * 
     * @param clz
     * @return
     */
    private static ToAlipayRequestConverter getConverter(Class<? extends ToAlipayModelRequest> clz) {

        ToAlipayRequestConverter converter = cacheMaps.get(clz);

        // 不存在实际类转换器，则查找默认基类转换器
        if (converter == null) {

            converter = cacheMaps.get(ToAlipayModelRequest.class);
        }

        // 都不存在则跑出异常
        if (converter == null) {

            LoggerUtil.error(logger, "请求类[" + clz + "]不存在对应转换器!");

            throw new AlipayDemoException(ResultEnum.NO_SUCH_CONVERTER.getResultCode(),
                String.format(ResultEnum.NO_SUCH_CONVERTER.getResultMsg(), clz.toString()));
        }

        return converter;

    }

    /**
     *  业务请求->实际请求
     * 
     * @param toAlipayModelRequest
     * @return
     */
    public static ToAlipayTargetRequest buildTargetReqFromModel(ToAlipayModelRequest toAlipayModelRequest) {

        return getConverter(toAlipayModelRequest.getClass()).convert(toAlipayModelRequest);

    }

}
